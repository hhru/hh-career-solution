package ru.hh.career.solution.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "area")
public class Area {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "area_id")
  private Integer areaId;

  private String name;

  public Area() {
  }

  public Area(Integer areaId, String name) {
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
