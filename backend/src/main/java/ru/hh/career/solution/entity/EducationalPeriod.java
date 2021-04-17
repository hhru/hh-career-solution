package ru.hh.career.solution.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "educational_period")
public class EducationalPeriod {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "year_from", nullable = false)
  private LocalDate yearFrom;

  @Column(name = "year_to")
  private LocalDate yearTo;

  public EducationalPeriod() {
  }

  public EducationalPeriod(Integer id, LocalDate yearFrom, LocalDate yearTo) {
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
