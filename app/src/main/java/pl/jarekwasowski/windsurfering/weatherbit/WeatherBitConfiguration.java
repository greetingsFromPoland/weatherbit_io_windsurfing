package pl.jarekwasowski.windsurfering.weatherbit;

import io.weatherbit.client.WeatherBitClient;
import io.weatherbit.client.WeatherBitClientData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherBitConfiguration {

    private final RestTemplate restTemplate;
    private final WeatherBitClientData weatherBitClientData;

    public WeatherBitConfiguration(
            RestTemplate restTemplate,
            WeatherBitClientData weatherBitClientData) {
        this.restTemplate = restTemplate;
        this.weatherBitClientData = weatherBitClientData;
    }

    @Bean
    WeatherBitClient weatherBitClient() {

        return new WeatherBitClient(restTemplate, weatherBitClientData);
    }
}
