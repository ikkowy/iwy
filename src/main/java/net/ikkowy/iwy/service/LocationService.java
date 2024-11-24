package net.ikkowy.iwy.service;

import net.ikkowy.iwy.dto.LocationDTO;
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

    public Location createLocation(LocationDTO locationDTO) {
        Location location = new Location();
        location.setName(locationDTO.getName());
        location.setDescription(locationDTO.getDescription());
        return locationRepository.save(location);
    }

    public LocationDTO convertEntityToDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setUuid(location.getUuid());
        locationDTO.setName(location.getName());
        locationDTO.setDescription(location.getDescription());
        return locationDTO;
    }

}
