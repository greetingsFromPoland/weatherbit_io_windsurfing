package pl.jarekwasowski.windsurfering.location;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class WindsurfingLocation {

    String name;

    double longitude;
    double latitude;

}
