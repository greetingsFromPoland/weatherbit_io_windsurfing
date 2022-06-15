package pl.jarekwasowski.windsurfering.weather;

import pl.jarekwasowski.windsurfering.location.WindsurfingLocation;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface WindsurferWeatherService {

    Optional<WindsurfingWeather> getWeather(WindsurfingLocation location, LocalDate date);

    Optional<WindsurfingWeather> getWeatherForBestLocation(LocalDate date);

    Optional<WindsurfingWeather> getWeatherForBestLocation(LocalDate date, Set<WindsurfingLocation> windsurfingLocations);


}
