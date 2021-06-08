package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class AreaDto {
  private Integer id;
  private String name;
  @JsonProperty("parent_id")
  private Integer parentId;
  @JsonProperty("areas")
  private Set<AreaDto> areaDtos;

  public AreaDto() {
  }

  public AreaDto(Integer id, String name, Integer parentId) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
  }

  public Set<AreaDto> getAreaDtos() {
    return areaDtos;
  }

  public void setAreaDtos(Set<AreaDto> areaDtos) {
    this.areaDtos = areaDtos;
  }

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

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }


}
