package ru.hh.career.solution.dto;

public class AreaDto {

  private Integer areaId;

  private String name;

  public AreaDto() {
  }

  public AreaDto(Integer areaId, String name) {
    this.areaId = areaId;
    this.name = name;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public String getName() {
    return name;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public void setName(String name) {
    this.name = name;
  }
}
