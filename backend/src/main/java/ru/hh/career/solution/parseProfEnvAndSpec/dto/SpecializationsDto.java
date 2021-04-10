package ru.hh.career.solution.parseProfEnvAndSpec.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = SpecializationsDeserializer.class)
public class SpecializationsDto {
    private Integer id;
    private String name;
    private Boolean laboring;

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

    public Boolean getLaboring() {
        return laboring;
    }

    public void setLaboring(Boolean laboring) {
        this.laboring = laboring;
    }
}
