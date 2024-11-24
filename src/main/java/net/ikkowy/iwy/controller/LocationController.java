package net.ikkowy.iwy.controller;

import net.ikkowy.iwy.dto.LocationDTO;
import net.ikkowy.iwy.service.LocationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    Page<LocationDTO> getLocations(Pageable pageable) {
        return locationService.getLocations(pageable).map(locationService::convertEntityToDTO);
    }

    @GetMapping("/{uuid}")
    LocationDTO getLocationByUuid(@PathVariable UUID uuid) {
        return locationService.convertEntityToDTO(locationService.getLocationByUuid(uuid));
    }

    @PostMapping
    LocationDTO createLocation(@RequestBody LocationDTO locationDTO) {
        return locationService.convertEntityToDTO(locationService.createLocation(locationDTO));
    }

}
