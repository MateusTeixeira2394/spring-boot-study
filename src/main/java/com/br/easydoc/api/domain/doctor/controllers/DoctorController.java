package com.br.easydoc.api.domain.doctor.controllers;

import com.br.easydoc.api.domain.doctor.models.dtos.CreateDoctorDTO;
import com.br.easydoc.api.domain.doctor.models.dtos.DoctorDTO;
import com.br.easydoc.api.domain.doctor.models.dtos.ListDoctorDTO;
import com.br.easydoc.api.domain.doctor.models.dtos.UpdateDoctorDTO;
import com.br.easydoc.api.domain.doctor.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping
    public String create(@RequestBody @Valid CreateDoctorDTO body){
        service.save(body);
        return "doctor created";
    }

    @GetMapping
    public Page<ListDoctorDTO> list(@PageableDefault(size=10,sort = {"name"}) Pageable pagination){
        return service.list(pagination);
    }

    @GetMapping("/{doctorId}")
    public DoctorDTO getOne(@PathVariable Long doctorId){
        return service.getOne(doctorId);
    }

    @PatchMapping
    public String update(@RequestBody @Valid UpdateDoctorDTO body) {
        this.service.update(body);
        return "Doctor updated";
    }

    @DeleteMapping("/{doctorId}")
    public String delete(@PathVariable Long doctorId){
        this.service.delete(doctorId);
        return "Doctor deleted";
    }

}
