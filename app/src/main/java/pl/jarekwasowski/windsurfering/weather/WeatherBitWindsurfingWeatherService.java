package pl.jarekwasowski.windsurfering.weather;

import io.weatherbit.client.Coordinate;
import io.weatherbit.client.WeatherBitClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.jarekwasowski.windsurfering.location.WindsurfingLocation;
import pl.jarekwasowski.windsurfering.location.WindsurfingLocationService;
import pl.jarekwasowski.windsurfering.weather.exception.DateOutOfRangeException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Service
@Log4j2
class WeatherBitWindsurfingWeatherService implements WindsurferWeatherService {

    private final WeatherBitClient weatherBitClient;
    private final WindsurfingLocationService windsurfingLocationService;
    private final WindsurfingWeatherMapper windsurfingWeatherMapper;

    public WeatherBitWindsurfingWeatherService(WeatherBitClient weatherBitClient,
                                               WindsurfingLocationService windsurfingLocationService,
                                               WindsurfingWeatherMapper windsurfingWeatherMapper) {
        this.weatherBitClient = weatherBitClient;
        this.windsurfingLocationService = windsurfingLocationService;
        this.windsurfingWeatherMapper = windsurfingWeatherMapper;
    }

    @Override
    public Optional<WindsurfingWeather> getWeather(WindsurfingLocation location, LocalDate date) {
        log.debug("get weather for {} for the day {} from WeatherBit", location, date);

        if (!date.isBefore(LocalDate.now().plusDays(16))
                || !date.isAfter(LocalDate.now().minusDays(1))
        ) {
            log.warn("Date out of range {} - now is {}", date, LocalDate.now());
            throw new DateOutOfRangeException();
        }

        return weatherBitClient.get16DaysForecast(
                        Coordinate.builder().latitude(
                                location.getLatitude()
                        ).longitude(
                                location.getLatitude()
                        ).build())
                .getWeatherInDays()
                .stream()
                .filter(it -> it.getDate().equals(date))
                .map(it -> windsurfingWeatherMapper.map(it, location))
                .findFirst();
    }

    @Override
    public Optional<WindsurfingWeather> getWeatherForBestLocation(LocalDate date) {
        return getWeatherForBestLocation(date, windsurfingLocationService.getAllWindsurfingLocations());
    }

    @Override
    public Optional<WindsurfingWeather> getWeatherForBestLocation(LocalDate date, Set<WindsurfingLocation> windsurfingLocations) {
        return windsurfingLocations
                .stream()
                .map(it -> getWeather(it, date))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(WindsurfingWeather::isSuitable)
                .sorted(new WindsurfingWeatherRangingComparator())
                .findFirst();
    }

}
