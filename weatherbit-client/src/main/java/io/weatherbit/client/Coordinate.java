package io.weatherbit.client;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Coordinate {

    private double latitude;
    private double longitude;
}
