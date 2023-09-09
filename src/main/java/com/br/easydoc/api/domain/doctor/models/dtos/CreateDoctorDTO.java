package com.br.easydoc.api.domain.doctor.models.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public class CreateDoctorDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    private String crm;

    @NotBlank
    private String speciality;

    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}")
    private String telephone;

    @NotEmpty
    @Valid
    private List<CreateAddressDTO> addresses;

    public CreateDoctorDTO(String name, String email, String crm, String speciality, List<CreateAddressDTO> createAddressDTO) {
        this.name = name;
        this.email = email;
        this.crm = crm;
        this.speciality = speciality;
        this.addresses = createAddressDTO;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public List<CreateAddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CreateAddressDTO> createAddressDTO) {
        this.addresses = createAddressDTO;
    }
}


// "name":"mateus",
//         "email":"mateus@easydoc.com",
//         "telephone":"9999-9999",
//         "crm": 11111,
//         "specialty": "Neurologia",
//         "address": {
//         "number": 488,
//         "street": "Rua Dr Gilberto Sturdart",
//         "neighborhood": "Cocó",
//         "complement": "apto 903",
//         "city": "Fortaleza",
//         "state": "Ceará",
//         "country": "Brazil",
//         "zipcode": "60192-105"
//         }
