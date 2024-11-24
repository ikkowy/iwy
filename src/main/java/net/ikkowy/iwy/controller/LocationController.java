package net.ikkowy.iwy.controller;

import net.ikkowy.iwy.dto.LocationDTO;
import net.ikkowy.iwy.filter.LocationFilter;
import net.ikkowy.iwy.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    List<LocationDTO> getLocations(@RequestParam Optional<UUID> uuid,
                                   @RequestParam Optional<String> sortBy,
                                   @RequestParam Optional<Boolean> descending) {
        LocationFilter locationFilter = new LocationFilter();
        locationFilter.setUuid(uuid.orElse(null));
        locationFilter.setSortBy(sortBy.orElse(null));
        locationFilter.setDescending(descending.orElse(false));
        return locationService.filter(locationFilter).stream()
                .map(locationService::convertEntityToDTO).toList();
    }

    @PostMapping
    LocationDTO createLocation(@RequestBody LocationDTO locationDTO) {
        return locationService.convertEntityToDTO(locationService.create(locationDTO));
    }

}
