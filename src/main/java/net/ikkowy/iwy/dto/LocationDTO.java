package net.ikkowy.iwy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class LocationDTO {

    @Getter
    @Setter
    private UUID uuid;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

}
