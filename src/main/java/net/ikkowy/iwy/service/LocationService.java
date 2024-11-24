package net.ikkowy.iwy.service;

import net.ikkowy.iwy.dto.LocationDTO;
import net.ikkowy.iwy.filter.LocationFilter;
import net.ikkowy.iwy.model.Location;
import net.ikkowy.iwy.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> filter(LocationFilter filter) {
        if (filter.getUuid() != null) {
            return List.of(locationRepository.findByUuid(filter.getUuid()));
        }
        return locationRepository.findAll();
    }

    public Location create(LocationDTO locationDTO) {
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
