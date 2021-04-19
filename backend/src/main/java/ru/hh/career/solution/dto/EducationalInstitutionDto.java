package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EducationalInstitutionDto {

  private Integer id;

  private String countryIsoCode;

  private String name;

  private String site;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updated;

  private EducationalPeriodDto educationalPeriod;

  public EducationalInstitutionDto(Integer id, String countryIsoCode, String name, String site,
                                   LocalDateTime created, LocalDateTime updated) {
    this.id = id;
    this.countryIsoCode = countryIsoCode;
    this.name = name;
    this.site = site;
    this.created = created;
    this.updated = updated;
  }

  public EducationalInstitutionDto(Integer id, String countryIsoCode, String name, String site,
                                   EducationalPeriodDto educationalPeriod) {
    this.id = id;
    this.countryIsoCode = countryIsoCode;
    this.name = name;
    this.site = site;
    this.educationalPeriod = educationalPeriod;
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
}
