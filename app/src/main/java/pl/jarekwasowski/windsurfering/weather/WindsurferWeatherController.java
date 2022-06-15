package pl.jarekwasowski.windsurfering.weather;

import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.jarekwasowski.windsurfering.weather.exception.NoFoundAnyLocationException;
import pl.jarekwasowski.windsurfering.weather.exception.UserExceptionResponse;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/weather/")
@Api()
class WindsurferWeatherController {

    private final WindsurferWeatherService windsurferWeatherService;

    public WindsurferWeatherController(WindsurferWeatherService windsurferWeatherService) {
        this.windsurferWeatherService = windsurferWeatherService;
    }

    @ApiOperation(value = "Find the best windsurfing location for a date")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Best location found."),
            @ApiResponse(code = 204, message = "There are no suitable conditions for windsurfing in any of the locations we know.", response = UserExceptionResponse.class),
            @ApiResponse(code = 400, message = "Wrong date.", response = UserExceptionResponse.class),
            @ApiResponse(code = 500, message = "Error connecting to the weather server.", response = UserExceptionResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/bestToday")
    public WindsurfingWeather getTodayBestLocation(
            @ApiParam(value = "Date", required = true, format = "YYYY-mm-DD")
            @RequestParam(name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        return windsurferWeatherService
                .getWeatherForBestLocation(date)
                .orElseThrow(NoFoundAnyLocationException::new);
    }

}
