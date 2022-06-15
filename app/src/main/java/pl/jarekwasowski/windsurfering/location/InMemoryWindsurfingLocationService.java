package pl.jarekwasowski.windsurfering.location;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Log4j2
public class InMemoryWindsurfingLocationService implements WindsurfingLocationService {

    private final WindsurfingLocation[] allLocations = {
            WindsurfingLocation.builder().name("Jastarnia Poland").latitude(54.69606).longitude(18.67873).build(),
            WindsurfingLocation.builder().name("Bridgetown (Barbados)").latitude(13.103562).longitude(-59.603226).build(),
            WindsurfingLocation.builder().name("Fortaleza (Brazil)").latitude(-3.7737 ).longitude(-38.5748).build(),
            WindsurfingLocation.builder().name("Pissouri (Cyprus)").latitude(34.666664 ).longitude(32.6999972).build(),
            WindsurfingLocation.builder().name("Le Morne (Mauritius)").latitude(-20.450000).longitude(57.316667).build()
    };

    @Override
//    @Timed
    public Set<WindsurfingLocation> getAllWindsurfingLocations() {
        log.debug("Get all windsurfing locations");
        return Set.of(allLocations);
    }
}
