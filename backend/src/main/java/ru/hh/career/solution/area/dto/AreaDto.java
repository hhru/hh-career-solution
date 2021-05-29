package ru.hh.career.solution.area.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = AreaDeserializer.class)
public class AreaDto {
  private Integer id;
  private String name;
  private Integer parentId;

  public List<AreaDto> getAreaDtos() {
    return areaDtos;
  }

  public void setAreaDtos(List<AreaDto> areaDtos) {
    this.areaDtos = areaDtos;
  }

  private List<AreaDto> areaDtos;

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
