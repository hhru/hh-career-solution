package ru.hh.career.solution.professionalenvironment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "specialization")
public class Specialization {

  public Specialization(Integer id, String name, Boolean laboring, ProfessionalEnvironment professionalEnvironment) {
    this.professionalEnvironment = professionalEnvironment;
    this.specializationId = id;
    this.specializationName = name;
    this.laboring = laboring;
  }

  public Specialization() {

  }

  @Id
  @Column(name = "specialization_id")
  private Integer specializationId;

  @Column(name = "specialization_name")
  private String specializationName;

  @Column(name = "laboring")
  private Boolean laboring;

  @JoinColumn(name = "professional_environment_id")
  @ManyToOne
  private ProfessionalEnvironment professionalEnvironment;

  public Integer getSpecializationId() {
    return specializationId;
  }

  public void setSpecializationId(Integer specializationId) {
    this.specializationId = specializationId;
  }

  public String getSpecializationName() {
    return specializationName;
  }

  public void setSpecializationName(String specializationName) {
    this.specializationName = specializationName;
  }

  public Boolean getLaboring() {
    return laboring;
  }

  public void setLaboring(Boolean laboring) {
    this.laboring = laboring;
  }

  public ProfessionalEnvironment getProfessionalEnvironment() {
    return professionalEnvironment;
  }

  public void setProfessionalEnvironment(ProfessionalEnvironment professionalEnvironment) {
    this.professionalEnvironment = professionalEnvironment;
  }
}
