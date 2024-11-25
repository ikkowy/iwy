package net.ikkowy.iwy.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    @Getter
    private UUID uuid;

    @Getter
    private Date createdAt;

    @Getter
    private Date modifiedAt;

    BaseEntity() {
        uuid = UUID.randomUUID();
        Date now = new Date();
        createdAt = now;
        modifiedAt = now;
    }

    public void updateModifiedAt() {
        modifiedAt = new Date();
    }

}
