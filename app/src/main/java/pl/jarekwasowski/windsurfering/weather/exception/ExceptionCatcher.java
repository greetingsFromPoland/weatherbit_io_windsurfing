package pl.jarekwasowski.windsurfering.weather.exception;


import io.weatherbit.client.WeatherBitConnectionException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
class ExceptionCatcher {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {WeatherBitConnectionException.class})
    @ResponseBody
    public UserExceptionResponse handleWeatherBitConnectionException(Exception ex) {
        return UserExceptionResponse
                .builder()
                .message("Connection error to weather server. Please try again in a moment.")
                .build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(value = {NoFoundAnyLocationException.class})
    @ResponseBody
    public UserExceptionResponse handleNoFoundAnyLocationException(Exception ex) {
       return UserExceptionResponse
                .builder()
                .message("There are no suitable conditions for windsurfing in any of the locations we know.")
                .build();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {DateOutOfRangeException.class})
    @ResponseBody
    public UserExceptionResponse handleDateOutOfRangeException(Exception ex) {
        return UserExceptionResponse
                .builder()
                .message("The date must be less than 16 days from now.")
                .build();
    }
}
