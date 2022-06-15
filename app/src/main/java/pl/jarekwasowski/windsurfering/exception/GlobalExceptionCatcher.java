package pl.jarekwasowski.windsurfering.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.net.BindException;

@Log4j2
public class GlobalExceptionCatcher {

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(value = {InvalidMediaTypeException.class, HttpMediaTypeNotSupportedException.class})
    public void handleUnsupportedMediaTypeException(Exception ex) {
        log.error("Unsupported or invalid media type.", ex);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MissingServletRequestParameterException.class, ServletRequestBindingException.class,
            MissingServletRequestPartException.class, BindException.class})
    public void handleBadRequestException(Exception ex) {
        log.error("Request parameter binding.", ex);
    }
}
