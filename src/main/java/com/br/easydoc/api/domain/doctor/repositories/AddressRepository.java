package com.br.easydoc.api.domain.doctor.repositories;

import com.br.easydoc.api.domain.doctor.models.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
