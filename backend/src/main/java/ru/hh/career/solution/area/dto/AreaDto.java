package ru.hh.career.solution.area.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//@JsonDeserialize(using = AreaDeserializer.class)
public class AreaDto {
  private Integer id;
  private String name;
  @JsonProperty("parent_id")
  private Integer parentId;
  @JsonProperty("areas")
  private List<AreaDto> areaDtos;

  public AreaDto() {

  }

  public List<AreaDto> getAreaDtos() {
    return areaDtos;
  }

  public void setAreaDtos(List<AreaDto> areaDtos) {
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
