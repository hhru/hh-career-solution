package ru.hh.career.solution.parseProfEnvAndSpec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = SpecDeserializer.class)
public class ProfEnvDTO {
    private Integer id;
    private String name;
    private List<SpecDTO> specialization;

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

    public List<SpecDTO> getSpecialization() {
        return specialization;
    }

    public void setSpecialization(List<SpecDTO> specialization) {
        this.specialization = specialization;
    }
}
