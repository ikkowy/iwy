package net.ikkowy.iwy.repository;

import net.ikkowy.iwy.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByUuid(UUID uuid);
}
