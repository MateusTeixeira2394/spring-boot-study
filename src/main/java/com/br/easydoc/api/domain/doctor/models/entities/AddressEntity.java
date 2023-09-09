package com.br.easydoc.api.domain.doctor.models.entities;

import com.br.easydoc.api.domain.doctor.models.dtos.AddressDTO;
import com.br.easydoc.api.domain.doctor.models.dtos.CreateAddressDTO;
import com.br.easydoc.api.domain.doctor.models.dtos.UpdateAddressDTO;
import jakarta.persistence.*;

@Table(name="addresses")
@Entity(name="Addresses")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private Long addressId;
    private Integer number;
    private String street;
    private String neighborhood;
    private String complement;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    @ManyToOne
    @JoinColumn(name = "doctor_id", columnDefinition = "doctor_id", nullable = false)
    private DoctorEntity doctor;

    public AddressEntity() {
    }

    public AddressEntity(CreateAddressDTO dto){
        this.number = dto.getNumber();
        this.street = dto.getStreet();
        this.city = dto.getCity();
        this.state = dto.getState();
        this.country = dto.getCountry();
        this.zipcode = dto.getZipcode();
        this.complement = dto.getComplement();
        this.neighborhood = dto.getNeighborhood();
    }

    public void updateFields(UpdateAddressDTO dto){

        if(dto.getNumber() != null){
            this.setNumber(dto.getNumber());
        }

        if(dto.getStreet() != null && !dto.getStreet().isBlank()){
            this.setStreet(dto.getStreet());
        }

        if(dto.getCity() != null && !dto.getCity().isBlank()){
            this.setCity(dto.getCity());
        }

        if(dto.getState() != null && !dto.getState().isBlank()){
            this.setState(dto.getState());
        }

        if(dto.getCountry() != null && !dto.getCountry().isBlank()){
            this.setCountry(dto.getCountry());
        }

        if(dto.getZipcode() != null && !dto.getZipcode().isBlank()){
            this.setZipcode(dto.getZipcode());
        }

        if(dto.getComplement() != null && !dto.getComplement().isBlank()){
            this.setComplement(dto.getComplement());
        }

        if(dto.getZipcode() != null && !dto.getZipcode().isBlank()){
            this.setZipcode(dto.getZipcode());
        }

    }

    public DoctorEntity getDoctor() {
        return doctor;
    }
    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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
