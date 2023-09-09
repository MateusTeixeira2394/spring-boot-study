package com.br.easydoc.api.domain.doctor.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CreateAddressDTO {
    @NotNull
    private Integer number;
    @NotBlank
    private String street;
    private String neighborhood;
    private String complement;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String country;
    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}")
    private String zipcode;

    public CreateAddressDTO(Integer number, String street, String neighborhood, String complement, String city, String state, String country, String zipcode) {
        this.number = number;
        this.street = street;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
