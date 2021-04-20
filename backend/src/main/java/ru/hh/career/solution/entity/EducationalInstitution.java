package ru.hh.career.solution.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "educational_institution")
public class EducationalInstitution {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "country_iso_code", nullable = false)
  private String countryIsoCode;

  private String name;

  private String site;

  private LocalDateTime created;

  private LocalDateTime updated;

  public EducationalInstitution() {
  }

  public EducationalInstitution(Integer id, String countryIsoCode, String name, String site, LocalDateTime created, LocalDateTime updated) {
    this.id = id;
    this.countryIsoCode = countryIsoCode;
    this.name = name;
    this.site = site;
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

  public String getSite() {
    return site;
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

  public void setSite(String site) {
    this.site = site;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }
}
