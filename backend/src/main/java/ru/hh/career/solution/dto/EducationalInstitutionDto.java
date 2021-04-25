package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EducationalInstitutionDto {

  private Integer id;

  private String countryIsoCode;

  private String name;

  private String site;

  private LocalDateTime created;

  private LocalDateTime updated;

  private EducationalPeriodDto educationalPeriod;

  private String diplomaLink;

  public EducationalInstitutionDto(Integer id, String countryIsoCode, String name, String site,
                                   EducationalPeriodDto educationalPeriod, String diplomaLink) {
    this.id = id;
    this.countryIsoCode = countryIsoCode;
    this.name = name;
    this.site = site;
    this.educationalPeriod = educationalPeriod;
    this.diplomaLink = diplomaLink;
  }

  public EducationalInstitutionDto(Integer id, EducationalPeriodDto educationalPeriod, String diplomaLink) {
    this.id = id;
    this.educationalPeriod = educationalPeriod;
    this.diplomaLink = diplomaLink;
  }

  public EducationalInstitutionDto() {
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

  public EducationalPeriodDto getEducationalPeriod() {
    return educationalPeriod;
  }

  public void setEducationalPeriod(EducationalPeriodDto educationalPeriod) {
    this.educationalPeriod = educationalPeriod;
  }

  public String getDiplomaLink() {
    return diplomaLink;
  }

  public void setDiplomaLink(String diplomaLink) {
    this.diplomaLink = diplomaLink;
  }
}
