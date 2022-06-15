package io.weatherbit.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;


@Data
public class Weather {

    private double windSpeed;
    private short windDirection;
    private short temperature;
    private short minTemperature;
    private LocalDate date;

    public Weather(
            @JsonProperty("wind_spd")
            double windSpeed,
            @JsonProperty("wind_dir")
            short windDirection,
            @JsonProperty("temp")
            short temperature,
            @JsonProperty("min_temp")
            short minTemperature,
            @JsonProperty("datetime")
            LocalDate date) {
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.temperature = temperature;
        this.minTemperature = minTemperature;
        this.date = date;
    }
}
/*


     "moonrise_ts": 1656467813,
      "wind_cdir": "NE",
      "wind_gust_spd": 9.6,
      "wind_spd": 4.4,
      "wind_dir": 53,
      "datetime": "2022-06-29",
      "temp": 19.5,
      "min_temp": 15.7

 */