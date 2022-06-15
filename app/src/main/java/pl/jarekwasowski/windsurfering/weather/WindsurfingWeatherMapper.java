package pl.jarekwasowski.windsurfering.weather;

import io.weatherbit.client.Weather;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pl.jarekwasowski.windsurfering.location.WindsurfingLocation;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface WindsurfingWeatherMapper {

    @Mapping(target = "windsurfingLocation", source = "location")
    @Mapping(target = "windSpeed", source = "weather.windSpeed")
    @Mapping(target = "windDirection", source = "weather.windDirection")
    @Mapping(target = "temperature", source = "weather.temperature")
    @Mapping(target = "date", source = "weather.date")
    @Mapping(target = "minTemperature", source = "weather.minTemperature")
    WindsurfingWeather map(Weather weather, WindsurfingLocation location);
}

