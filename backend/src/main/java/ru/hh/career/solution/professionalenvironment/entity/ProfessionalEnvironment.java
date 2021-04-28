package ru.hh.career.solution.professionalenvironment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "professional_environment")
public class ProfessionalEnvironment {

  public ProfessionalEnvironment(Integer id, String professionalEnvironmentName) {
    this.id = id;
    this.professionalEnvironmentName = professionalEnvironmentName;
  }

  public ProfessionalEnvironment() {

  }

  @Id
  @Column(name = "professional_environment_id")
  private Integer id;

  @Column(name = "professional_environment_name")
  private String professionalEnvironmentName;

  @OneToMany(mappedBy = "professionalEnvironment", orphanRemoval = true)
  private Set<Specialization> specializationSet;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProfessionalEnvironmentName() {
    return professionalEnvironmentName;
  }

  public void setProfessionalEnvironmentName(String professionalEnvironmentName) {
    this.professionalEnvironmentName = professionalEnvironmentName;
  }

  public Set<Specialization> getSpecializationSet() {
    return specializationSet;
  }

  public void setSpecializationSet(Set<Specialization> specializationSet) {
    this.specializationSet = specializationSet;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ProfessionalEnvironment that = (ProfessionalEnvironment) o;
      return getId().equals(that.getId()) && getProfessionalEnvironmentName().equals(that.getProfessionalEnvironmentName());
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getProfessionalEnvironmentName());
  }
}
