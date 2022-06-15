package pl.jarekwasowski.windsurfering.weather;

import java.util.Comparator;

class WindsurfingWeatherRangingComparator implements Comparator<WindsurfingWeather> {
    @Override
    public int compare(WindsurfingWeather o1, WindsurfingWeather o2) {
        return Integer.compare(o1.getRanking(), o2.getRanking());
    }
}
