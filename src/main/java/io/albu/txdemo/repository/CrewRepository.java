package io.albu.txdemo.repository;

import io.albu.txdemo.model.CrewEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<CrewEntity, UUID> {
}
