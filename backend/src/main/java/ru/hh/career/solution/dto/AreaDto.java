package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AreaDto {

  private Integer id;

  private String countryIsoCode;

  private String name;

  private LocalDateTime created;

  private LocalDateTime updated;

  public AreaDto() {
  }

  public AreaDto(Integer id, String countryIsoCode, String name) {
    this.id = id;
    this.countryIsoCode = countryIsoCode;
    this.name = name;
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
