package com.br.easydoc.api.domain.doctor.models.dtos;

public class ListDoctorDTO {

    private Long id;
    private String name;
    private String email;
    private String crm;
    private String speciality;

    public ListDoctorDTO(Long id, String name, String email, String crm, String speciality) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.crm = crm;
        this.speciality = speciality;
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
}
