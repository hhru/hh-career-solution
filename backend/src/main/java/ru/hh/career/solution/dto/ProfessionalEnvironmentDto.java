package ru.hh.career.solution.dto;

public class ProfessionalEnvironmentDto {

  private Integer id;

  private String name;

  public ProfessionalEnvironmentDto(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public ProfessionalEnvironmentDto() {
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
