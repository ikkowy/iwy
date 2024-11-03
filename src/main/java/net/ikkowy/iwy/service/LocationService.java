package net.ikkowy.iwy.service;

import net.ikkowy.iwy.dto.LocationDTO;
import net.ikkowy.iwy.model.Location;
import net.ikkowy.iwy.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationDTO> getLocations(UUID uuid) {
        List<Location> result;
        if (uuid != null) {
            result = List.of(locationRepository.findByUuid(uuid));
        } else {
            result = locationRepository.findAll();
        }
        return result.stream().map(this::convertEntityToDTO).toList();
    }

    public LocationDTO createLocation(LocationDTO locationDTO) {
        Location location = new Location();
        location.setName(locationDTO.getName());
        location.setDescription(locationDTO.getDescription());
        return convertEntityToDTO(locationRepository.save(location));
    }

    public LocationDTO convertEntityToDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setUuid(location.getUuid());
        locationDTO.setName(location.getName());
        locationDTO.setDescription(location.getDescription());
        return locationDTO;
    }

}
