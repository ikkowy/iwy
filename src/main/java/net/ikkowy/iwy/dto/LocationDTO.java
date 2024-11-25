package net.ikkowy.iwy.dto;

import lombok.Getter;
import lombok.Setter;
import net.ikkowy.iwy.model.Location;

@Setter
@Getter
public class LocationDTO extends BaseDTO {

    private String name;

    private String description;

    public LocationDTO() {
    }

    public LocationDTO(Location location) {
        super(location);
        setName(location.getName());
        setDescription(location.getDescription());
    }

}
