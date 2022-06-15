package io.weatherbit.client;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class WeatherBitClient {

    private final RestTemplate restTemplate;
    private final WeatherBitClientData weatherbitClientData;

    public WeatherBitClient(RestTemplate restTemplate, WeatherBitClientData weatherbitClientData) {
        this.restTemplate = restTemplate;
        this.weatherbitClientData = weatherbitClientData;
    }


    /**
     * Gets 16 days of weather for given GPS coordinates.
     * @param coordinate GPS coordinates to check.
     * @return Weather forecast
     */
    public Forecast get16DaysForecast(Coordinate coordinate) {
        log.warn("Get 16 days of weather for your coordinates {}", coordinate);

        String urlWithQueryParams = String
                .format("%s/forecast/daily?key=%s&lat=%f&lon=%f", weatherbitClientData.getApiUrl(),
                        weatherbitClientData.getApiKey(), coordinate.getLatitude(),
                        coordinate.getLongitude());
        Forecast forecast;

        try {
            forecast = restTemplate.getForObject(urlWithQueryParams, Forecast.class);
        } catch (Exception ex) {
            log.warn("IOE when calling weatherBit API.", ex);
            throw new WeatherBitConnectionException(ex);
        }

        return forecast;
    }

}
