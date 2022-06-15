package pl.jarekwasowski.windsurfering.weatherbit;

import io.weatherbit.client.WeatherBitClientData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesWeatherBitClientData implements WeatherBitClientData {

    @Value("${weatherBit.apiKey}")
    private String apiKey;

    @Value("${weatherBit.url}")
    private String apiUrl;

    @Override
    public String getApiKey() {
        return apiKey;
    }

    @Override
    public String getApiUrl() {
        return apiUrl;
    }
}
