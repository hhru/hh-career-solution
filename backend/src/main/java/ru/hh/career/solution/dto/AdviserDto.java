package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdviserDto {
    private Integer adviserId;
    private String name;
    private String soname;
    private String created;
    private String updated;


    public AdviserDto() {}

    public AdviserDto(Integer adviserId, String name, String soname, String created, String updated) {
        this.adviserId = adviserId;
        this.name = name;
        this.soname = soname;
        this.created = created;
        this.updated = updated;
    }

    public void setAdviserId(Integer adviserId) {
        this.adviserId = adviserId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public Integer getAdviserId() {
        return adviserId;
    }

    public String getName() {
        return name;
    }

    public String getSoname() {
        return soname;
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
