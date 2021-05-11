package ru.hh.career.solution.area.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "area")
public class Area {
  public Area(Integer id, String name, Integer parentId) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
  }

  public Area() {

  }

  @Id
  @Column(name = "area_id")
  private Integer id;

  @Column(name = "area_name")
  private String name;

  @Column(name = "area_parent")
  private Integer parentId;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Area)) {
      return false;
    }
    Area area = (Area) o;
    return Objects.equals(getId(), area.getId()) && Objects.equals(getName(), area.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName());
  }
}
