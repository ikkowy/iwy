package net.ikkowy.iwy.service;

import net.ikkowy.iwy.model.Location;
import net.ikkowy.iwy.repository.LocationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Page<Location> getLocations(Pageable pageable) {
        return locationRepository.findAll(pageable);
    }

    public Location getLocationByUuid(UUID uuid) {
        return locationRepository.findByUuid(uuid);
    }

    public Location createLocation(String name, String description) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Argument 'name' must not be null or blank.");
        }
        Location location = new Location();
        location.setName(name);
        location.setDescription(description);
        return locationRepository.save(location);
    }

    public Location updateLocation(UUID uuid, String name, String description) {
        Location location = locationRepository.findByUuid(uuid);
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Location name must not be null or blank.");
        }
        if (location == null) {
            throw new RuntimeException(String.format("Cannot find a location with UUID '%s'.", uuid));
        }
        location.setName(name);
        location.setDescription(description);
        location.updateModifiedAt();
        return locationRepository.save(location);
    }

}
