package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EducationalPeriodDto {

  private Integer id;

  private LocalDate yearFrom;

  private LocalDate yearTo;

  public EducationalPeriodDto(Integer id, LocalDate yearFrom, LocalDate yearTo) {
    this.id = id;
    this.yearFrom = yearFrom;
    this.yearTo = yearTo;
  }

  public Integer getId() {
    return id;
  }

  public LocalDate getYearFrom() {
    return yearFrom;
  }

  public LocalDate getYearTo() {
    return yearTo;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setYearFrom(LocalDate yearFrom) {
    this.yearFrom = yearFrom;
  }

  public void setYearTo(LocalDate yearTo) {
    this.yearTo = yearTo;
  }
}
