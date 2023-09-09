package com.br.easydoc.api.domain.doctor.repositories;

import com.br.easydoc.api.domain.doctor.models.entities.DoctorEntity;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    Page<DoctorEntity> findAllByActivatedTrue(Pageable pagination);

    @Query("SELECT d FROM Doctors d WHERE d.doctorId = :id AND d.activated = true")
    DoctorEntity getActivatedEntityById(@Param("id") Long id);

}
