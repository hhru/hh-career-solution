package ru.hh.career.solution.parseProfEnvAndSpec.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = ProfessionalEnvironmentDeserializer.class)
public class ProfessionalEnvironmentDTO {
    private Integer id;
    private String name;
    private List<SpecializationsDto> specialization;

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

    public List<SpecializationsDto> getSpecialization() {
        return specialization;
    }

    public void setSpecialization(List<SpecializationsDto> specialization) {
        this.specialization = specialization;
    }
}
