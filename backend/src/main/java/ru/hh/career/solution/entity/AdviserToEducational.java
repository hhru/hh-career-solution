package ru.hh.career.solution.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "adviser_to_educational")
public class AdviserToEducational {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "adviser_id")
  private Integer adviserId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "educational_institution_id")
  private EducationalInstitution educationalInstitution;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "educational_period_id")
  private EducationalPeriod educationalPeriod;

  @Column(name = "diploma_link")
  private String diplomaLink;

  public AdviserToEducational() {
  }

  public AdviserToEducational(Integer id, Integer adviserId, EducationalInstitution educationalInstitution,
                              EducationalPeriod educationalPeriod, String diplomaLink) {
    this.id = id;
    this.adviserId = adviserId;
    this.educationalInstitution = educationalInstitution;
    this.educationalPeriod = educationalPeriod;
    this.diplomaLink = diplomaLink;
  }

  public EducationalPeriod getEducationalPeriod() {
    return educationalPeriod;
  }

  public String getDiplomaLink() {
    return diplomaLink;
  }

  public void setEducationalPeriod(EducationalPeriod educationalPeriod) {
    this.educationalPeriod = educationalPeriod;
  }

  public void setDiplomaLink(String diplomaLink) {
    this.diplomaLink = diplomaLink;
  }

  public EducationalInstitution getEducationalInstitution() {
    return educationalInstitution;
  }

  public void setEducationalInstitution(EducationalInstitution educationalInstitution) {
    this.educationalInstitution = educationalInstitution;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setAdviserId(Integer adviserId) {
    this.adviserId = adviserId;
  }

  public Integer getId() {
    return id;
  }

  public Integer getAdviserId() {
    return adviserId;
  }

}
