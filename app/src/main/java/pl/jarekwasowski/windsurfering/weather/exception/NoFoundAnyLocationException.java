package pl.jarekwasowski.windsurfering.weather.exception;

public class NoFoundAnyLocationException extends RuntimeException {
    public NoFoundAnyLocationException(Throwable cause) {
        super(cause);
    }

    public NoFoundAnyLocationException() {
    }
}
