package ru.hh.career.solution.professionalenvironment.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = SpecializationDeserializer.class)
public class SpecializationDto {
  private Integer specializationId;
  private Integer professionalEnvironmentId;
  private String name;
  private Boolean laboring;

  public SpecializationDto(Integer specializationId, Integer professionalEnvironmentId, String name, Boolean laboring) {
    this.specializationId = specializationId;
    this.professionalEnvironmentId = professionalEnvironmentId;
    this.name = name;
    this.laboring = laboring;
  }

  public SpecializationDto() {
  }

  public Integer getProfessionalEnvironmentId() {
    return professionalEnvironmentId;
  }

  public void setProfessionalEnvironmentId(Integer professionalEnvironmentId) {
    this.professionalEnvironmentId = professionalEnvironmentId;
  }

  public Integer getSpecializationId() {
    return specializationId;
  }

  public void setSpecializationId(Integer specializationId) {
    this.specializationId = specializationId;
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
