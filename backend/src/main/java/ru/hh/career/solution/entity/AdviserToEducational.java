package ru.hh.career.solution.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adviser_to_educational")
public class AdviserToEducational {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "adviser_id")
  private Integer adviserId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "educational_institution_id")
  private EducationalInstitution educationalInstitution;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "educational_period_id")
  private EducationalPeriod educationalPeriod;

  @Column(name = "document_link")
  private String documentLink;

  public AdviserToEducational() {
  }

  public AdviserToEducational(Integer id, Integer adviserId, EducationalInstitution educationalInstitution,
                              EducationalPeriod educationalPeriod, String documentLink) {
    this.id = id;
    this.adviserId = adviserId;
    this.educationalInstitution = educationalInstitution;
    this.educationalPeriod = educationalPeriod;
    this.documentLink = documentLink;
  }

  public Integer getId() {
    return id;
  }

  public Integer getAdviserId() {
    return adviserId;
  }

  public EducationalInstitution getEducationalInstitution() {
    return educationalInstitution;
  }

  public EducationalPeriod getEducationalPeriod() {
    return educationalPeriod;
  }

  public String getDocumentLink() {
    return documentLink;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setAdviserId(Integer adviserId) {
    this.adviserId = adviserId;
  }

  public void setEducationalInstitution(EducationalInstitution educationalInstitution) {
    this.educationalInstitution = educationalInstitution;
  }

  public void setEducationalPeriod(EducationalPeriod educationalPeriod) {
    this.educationalPeriod = educationalPeriod;
  }

  public void setDocumentLink(String documentLink) {
    this.documentLink = documentLink;
  }
}
