package org.sid.fieldsservice.repository;

import org.sid.fieldsservice.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {
    List<Field> findByLocation(String location);

    List<Field> findByIsAvailable(boolean isAvailable);

    List<Field> findByLocationAndIsAvailable(String location, boolean isAvailable);
}
