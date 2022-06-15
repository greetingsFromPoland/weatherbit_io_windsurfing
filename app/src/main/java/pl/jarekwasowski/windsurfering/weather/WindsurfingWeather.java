package pl.jarekwasowski.windsurfering.weather;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import pl.jarekwasowski.windsurfering.location.WindsurfingLocation;
import java.beans.Transient;
import java.time.LocalDate;

@Builder
@Getter
public class WindsurfingWeather {

    private WindsurfingLocation windsurfingLocation;
    private double windSpeed;
    private short windDirection;
    private short temperature;
    private short minTemperature;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Transient
    public int getRanking() {
        return (int) (windSpeed * 3 + temperature);
    }

    @Transient
    public boolean isSuitable() {
        return temperature > 5 && temperature < 35 && windSpeed > 5 && windSpeed < 18;
    }
}
