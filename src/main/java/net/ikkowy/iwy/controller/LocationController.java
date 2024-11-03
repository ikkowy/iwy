package net.ikkowy.iwy.controller;

import net.ikkowy.iwy.dto.LocationDTO;
import net.ikkowy.iwy.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    List<LocationDTO> getLocations(@RequestParam(required = false) UUID uuid) {
        return locationService.getLocations(uuid);
    }

    @PostMapping
    LocationDTO createLocation(@RequestBody LocationDTO locationDTO) {
        return locationService.createLocation(locationDTO);
    }

}
