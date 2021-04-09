package ru.hh.career.solution.professionalenvironmentandspecialization.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = SpecializationDeserializer.class)
public class SpecializationDto {
  private Integer idSpecialization;
  private Integer idProfessionalEnvironment;
  private String name;
  private Boolean laboring;

  public Integer getIdProfessionalEnvironment() {
    return idProfessionalEnvironment;
  }

  public void setIdProfessionalEnvironment(Integer idProfessionalEnvironment) {
    this.idProfessionalEnvironment = idProfessionalEnvironment;
  }

  public Integer getIdSpecialization() {
    return idSpecialization;
  }

  public void setIdSpecialization(Integer idSpecialization) {
    this.idSpecialization = idSpecialization;
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
