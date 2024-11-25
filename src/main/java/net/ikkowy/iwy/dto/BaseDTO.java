package net.ikkowy.iwy.dto;

import lombok.Getter;
import lombok.Setter;
import net.ikkowy.iwy.model.BaseEntity;

import java.util.UUID;

public class BaseDTO {

    @Getter
    @Setter
    private UUID uuid;

    BaseDTO() {
    }

    BaseDTO(final BaseEntity baseEntity) {
        setUuid(baseEntity.getUuid());
    }

}
