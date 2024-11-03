package net.ikkowy.iwy.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Location extends BaseEntity {

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    String description;

}
