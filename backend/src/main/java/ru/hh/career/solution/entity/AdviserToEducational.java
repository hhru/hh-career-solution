package ru.hh.career.solution.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "adviser_to_educational")
public class AdviserToEducational {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "adviser_id", nullable = false)
  private Integer adviserId;
//  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//  @JoinColumn(name = "adviser_id")
//  private Adviser adviser;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "educational_institution_id")
  private EducationalInstitution educationalInstitution;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "educational_period_id")
  private EducationalPeriod educationalPeriod;

  @Column(name = "document")
  private String documentLink;

  @Column(name = "created")
  private LocalDateTime created;

  @Column(name = "updated")
  private LocalDateTime updated;

  public AdviserToEducational() {
  }

  public AdviserToEducational(Integer adviserId, EducationalInstitution educationalInstitution,
                              EducationalPeriod educationalPeriod, String documentLink,
                              LocalDateTime created, LocalDateTime updated) {
    this.adviserId = adviserId;
    this.educationalInstitution = educationalInstitution;
    this.educationalPeriod = educationalPeriod;
    this.documentLink = documentLink;
    this.created = created;
    this.updated = updated;
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

  public LocalDateTime getCreated() {
    return created;
  }

  public LocalDateTime getUpdated() {
    return updated;
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

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
