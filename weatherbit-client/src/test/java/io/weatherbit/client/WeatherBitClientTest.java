package io.weatherbit.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class WeatherBitClientTest {

    private static final TestWeatherBitConfiguration testConfiguration = new TestWeatherBitConfiguration();
    private final static Coordinate warsawPolandCoordinate = Coordinate.builder().latitude(52.237049).longitude(21.017532).build();
    private final static RestTemplate restTemplate = new RestTemplate();

    @BeforeEach
    void setUp() {
    }

    @Test
    void is_api_client_to_weatherbit_working() {

        WeatherBitClient weatherBitClient = new WeatherBitClient(restTemplate, testConfiguration);
        Forecast forecast = weatherBitClient.get16DaysForecast(warsawPolandCoordinate);


        Assertions.assertEquals("PL", forecast.getCountryCode());
    }
}