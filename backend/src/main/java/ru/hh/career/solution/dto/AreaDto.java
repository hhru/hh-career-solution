package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AreaDto {

    @JsonProperty(required = true)
    private Integer areaId;

    public AreaDto() {
    }
}
