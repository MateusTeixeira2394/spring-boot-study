package com.br.easydoc.api.domain.doctor.models.entities;

import com.br.easydoc.api.domain.doctor.models.dtos.CreateDoctorDTO;
import com.br.easydoc.api.domain.doctor.models.dtos.UpdateAddressDTO;
import com.br.easydoc.api.domain.doctor.models.dtos.UpdateDoctorDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name="doctors")
@Entity(name="Doctors")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private Long doctorId;
    private String name;
    private String email;
    private String crm;
    private String speciality;
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private List<AddressEntity> addresses = new ArrayList<>();
    private boolean activated;

    public DoctorEntity() {}

    public DoctorEntity(CreateDoctorDTO dto){
        this.activated = true;
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.crm = dto.getCrm();
        this.speciality = dto.getSpeciality();
        this.telephone = dto.getTelephone();
    }

    public void updateFields(UpdateDoctorDTO dto){

        if(dto.getName() != null && !dto.getName().isBlank()){
            this.setName(dto.getName());
        }

        if(dto.getEmail() != null && !dto.getEmail().isBlank()){
            this.setEmail(dto.getEmail());
        }

        if(dto.getTelephone() != null && !dto.getTelephone().isBlank()){
            this.setTelephone(dto.getTelephone());
        }

        if(dto.getCrm() != null && !dto.getCrm().isBlank()){
            this.setCrm(dto.getCrm());
        }

        if(dto.getSpeciality() != null && !dto.getSpeciality().isBlank()){
            this.setSpeciality(dto.getSpeciality());
        }

        if(dto.getAddresses() != null && !dto.getAddresses().isEmpty()){
            for(UpdateAddressDTO addressDTO : dto.getAddresses()){
                AddressEntity addressEntity = this.getAddresses().stream().filter(current -> current.getAddressId() == addressDTO.getId()).toList().get(0);
                addressEntity.updateFields(addressDTO);
            }
        }

    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
