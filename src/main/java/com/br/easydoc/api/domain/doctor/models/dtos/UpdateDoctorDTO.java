package com.br.easydoc.api.domain.doctor.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public class UpdateDoctorDTO {

    @NotNull
    private Long id;
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "\\d{4,6}")
    private String crm;
    private String speciality;
    @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}")
    private String telephone;
    @Valid
    private List<UpdateAddressDTO> addresses;

    public UpdateDoctorDTO(Long id, String name, String email, String crm, String speciality, String telephone, List<UpdateAddressDTO> addresses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.crm = crm;
        this.speciality = speciality;
        this.telephone = telephone;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<UpdateAddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<UpdateAddressDTO> addresses) {
        this.addresses = addresses;
    }
}
