package com.br.easydoc.api.domain.doctor.models.dtos;

import com.br.easydoc.api.domain.doctor.models.entities.AddressEntity;

import java.util.ArrayList;
import java.util.List;

public class DoctorDTO {

    private Long doctorId;
    private String name;
    private String email;
    private String crm;
    private String speciality;
    private String telephone;
    private List<AddressDTO> addresses = new ArrayList<>();

    public DoctorDTO(Long doctorId, String name, String email, String crm, String speciality, String telephone, List<AddressEntity> addresses) {
        this.doctorId = doctorId;
        this.name = name;
        this.email = email;
        this.crm = crm;
        this.speciality = speciality;
        this.telephone = telephone;

        for (AddressEntity entity: addresses) {

            this.addresses.add(
                    new AddressDTO(
                            entity.getAddressId(),
                            entity.getNumber(),
                            entity.getStreet(),
                            entity.getNeighborhood(),
                            entity.getComplement(),
                            entity.getCity(),
                            entity.getState(),
                            entity.getCountry(),
                            entity.getZipcode()
                    )
            );

        }

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }
}
