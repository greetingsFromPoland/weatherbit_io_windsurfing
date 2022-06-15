package io.weatherbit.client;


public class TestWeatherBitConfiguration implements WeatherBitClientData {

    private static final String apiKey = "b860f5a5eb0b40f3b96e36b066895373";
    private static final String apiUrl = "https://api.weatherbit.io/v2.0";

    public TestWeatherBitConfiguration(){

    }

    @Override
    public String getApiKey() {
        return apiKey;
    }

    @Override
    public String getApiUrl() {
        return apiUrl;
    }
}
