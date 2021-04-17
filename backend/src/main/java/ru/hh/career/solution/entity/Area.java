package ru.hh.career.solution.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "area")
public class Area {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "country_iso_code", nullable = false)
  private String countryIsoCode;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "created")
  private LocalDateTime created;

  @Column(name = "updated")
  private LocalDateTime updated;

  public Area() {
  }

  public Area(Integer id, String countryIsoCode, String name, LocalDateTime created, LocalDateTime updated) {
    this.id = id;
    this.countryIsoCode = countryIsoCode;
    this.name = name;
    this.created = created;
    this.updated = updated;
  }

  public Integer getId() {
    return id;
  }

  public String getCountryIsoCode() {
    return countryIsoCode;
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

  public void setCountryIsoCode(String countryIsoCode) {
    this.countryIsoCode = countryIsoCode;
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
