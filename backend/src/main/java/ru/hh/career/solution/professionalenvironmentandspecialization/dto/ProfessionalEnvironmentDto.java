package ru.hh.career.solution.professionalenvironmentandspecialization.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = ProfessionalEnvironmentDeserializer.class)
public class ProfessionalEnvironmentDto {
  private Integer id;
  private String name;
  private List<SpecializationDto> specialization;

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

  public List<SpecializationDto> getSpecializations() {
    return specialization;
  }

  public void setSpecialization(List<SpecializationDto> specialization) {
    this.specialization = specialization;
  }
}
