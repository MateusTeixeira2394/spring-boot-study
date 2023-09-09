package com.br.easydoc.api.domain.doctor.services;

import com.br.easydoc.api.domain.doctor.models.dtos.*;
import com.br.easydoc.api.domain.doctor.models.entities.AddressEntity;
import com.br.easydoc.api.domain.doctor.models.entities.DoctorEntity;
import com.br.easydoc.api.domain.doctor.repositories.AddressRepository;
import com.br.easydoc.api.domain.doctor.repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public void save(CreateDoctorDTO dto){

        DoctorEntity doctor = new DoctorEntity(dto);
        doctorRepository.save(doctor);

        for(CreateAddressDTO createAddressDTO : dto.getAddresses()){
            AddressEntity addressEntity = new AddressEntity(createAddressDTO);
            addressEntity.setDoctor(doctor);
            addressRepository.save(addressEntity);
        }

    }

    public DoctorDTO getOne(Long doctorId){
        DoctorEntity doctor = doctorRepository.getActivatedEntityById(doctorId);
        return new DoctorDTO(doctor.getDoctorId(),doctor.getName(),doctor.getEmail(),doctor.getCrm(),doctor.getSpeciality(),doctor.getTelephone(),doctor.getAddresses());
    }

    public Page<ListDoctorDTO> list(Pageable pagination){
        return doctorRepository.findAllByActivatedTrue(pagination).map(d -> new ListDoctorDTO(d.getDoctorId(), d.getName(), d.getEmail(), d.getCrm(), d.getSpeciality()));
    }

    @Transactional
    public void update(UpdateDoctorDTO dto){
        DoctorEntity doctor = doctorRepository.getReferenceById(dto.getId());
        doctor.updateFields(dto);
    }
    @Transactional
    public void delete(Long doctorId) {
        DoctorEntity doctor = doctorRepository.getReferenceById(doctorId);
        doctor.setActivated(false);
    }
}
