package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EducationalPeriodDto {

  private Integer id;

  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate yearFrom;

  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate yearTo;

  public EducationalPeriodDto(Integer id, LocalDate yearFrom, LocalDate yearTo) {
    this.id = id;
    this.yearFrom = yearFrom;
    this.yearTo = yearTo;
  }

  public EducationalPeriodDto(LocalDate yearFrom, LocalDate yearTo) {
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
