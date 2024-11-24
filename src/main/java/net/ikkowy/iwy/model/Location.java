package net.ikkowy.iwy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Location extends BaseEntity {

    @Column(unique = true, nullable = false)
    String name;

    String description;

}
