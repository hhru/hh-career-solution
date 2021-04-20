package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfessionalSkillDto {

  private Integer id;

  private String name;

  private LocalDateTime created;

  private LocalDateTime updated;

  public ProfessionalSkillDto(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public ProfessionalSkillDto() {
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }
}
