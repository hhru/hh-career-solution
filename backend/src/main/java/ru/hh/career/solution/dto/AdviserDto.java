package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdviserDto {
    private Integer adviserId;
    @NotNull
    private String name;
    private String surname;
    private String created;
    private String updated;


    public AdviserDto() {}

    public AdviserDto(Integer adviserId, String name, String surname, String created, String updated) {
        this.adviserId = adviserId;
        this.name = name;
        this.surname = surname;
        this.created = created;
        this.updated = updated;
    }

    public AdviserDto(@NotNull String name) {
        this.name = name;
    }

    public void setAdviserId(Integer adviserId) {
        this.adviserId = adviserId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoname(String surname) {
        this.surname = surname;
    }

    public Integer getAdviserId() {
        return adviserId;
    }

    public String getName() {
        return name;
    }

    public String getSoname() {
        return surname;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
