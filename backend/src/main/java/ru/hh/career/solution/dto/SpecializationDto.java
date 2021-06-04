package ru.hh.career.solution.dto;

public class SpecializationDto {

  private Integer specializationId;

  private ProfessionalEnvironmentDto professionalEnvironment;

  private String name;

  private Boolean laboring;

  public SpecializationDto() {
  }

  public SpecializationDto(Integer specializationId, ProfessionalEnvironmentDto professionalEnvironment, String name, Boolean laboring) {
    this.specializationId = specializationId;
    this.professionalEnvironment = professionalEnvironment;
    this.name = name;
    this.laboring = laboring;
  }

  public Integer getSpecializationId() {
    return specializationId;
  }

  public ProfessionalEnvironmentDto getProfessionalEnvironment() {
    return professionalEnvironment;
  }

  public String getName() {
    return name;
  }

  public Boolean getLaboring() {
    return laboring;
  }

  public void setSpecializationId(Integer specializationId) {
    this.specializationId = specializationId;
  }

  public void setProfessionalEnvironment(ProfessionalEnvironmentDto professionalEnvironment) {
    this.professionalEnvironment = professionalEnvironment;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLaboring(Boolean laboring) {
    this.laboring = laboring;
  }
}
