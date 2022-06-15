package pl.jarekwasowski.windsurfering.weather.exception;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class UserExceptionResponse implements Serializable {

    private String message;
}
