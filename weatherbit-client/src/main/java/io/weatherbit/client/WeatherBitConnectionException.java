package io.weatherbit.client;

public class WeatherBitConnectionException extends RuntimeException {
    public WeatherBitConnectionException() {
        super();
    }

    public WeatherBitConnectionException(String message) {
        super(message);
    }

    public WeatherBitConnectionException(Throwable cause) {
        super(cause);
    }
}
