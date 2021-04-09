package ru.hh.career.solution.parseProfEnvAndSpec.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = SpecializationsDeserializer.class)
public class ProfessionalEnvironmentDTO {
    private Integer id;
    private String name;
    private List<SpecializationsDTO> specialization;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SpecializationsDTO> getSpecialization() {
        return specialization;
    }

    public void setSpecialization(List<SpecializationsDTO> specialization) {
        this.specialization = specialization;
    }
}
