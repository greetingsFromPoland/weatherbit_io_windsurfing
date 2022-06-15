package io.weatherbit.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Forecast {

    private String cityName;
    private double lon;
    private double lat;
    private String countryCode;
    private List<Weather> weatherInDays;

    @JsonCreator
    public Forecast(
            @JsonProperty("city_name")
            String cityName,
            @JsonProperty("lon")
            double lon,
            @JsonProperty("lat")
            double lat,
            @JsonProperty("country_code")
            String countryCode,
            @JsonProperty("data")
            List<Weather> weatherInDays) {

        this.cityName = cityName;
        this.lon = lon;
        this.lat = lat;
        this.countryCode = countryCode;
        this.weatherInDays = weatherInDays;
    }

}
