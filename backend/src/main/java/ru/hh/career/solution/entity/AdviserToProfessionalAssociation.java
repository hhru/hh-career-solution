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
@Table(name = "adviser_to_professional_association")
public class AdviserToProfessionalAssociation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "adviser_id")
  private Integer adviserId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "professional_association_id")
  private ProfessionalAssociation professionalAssociation;

  public AdviserToProfessionalAssociation() {
  }

  public AdviserToProfessionalAssociation(Integer id, Integer adviserId, ProfessionalAssociation professionalAssociation) {
    this.id = id;
    this.adviserId = adviserId;
    this.professionalAssociation = professionalAssociation;
  }

  public Integer getId() {
    return id;
  }

  public Integer getAdviserId() {
    return adviserId;
  }

  public ProfessionalAssociation getProfessionalAssociation() {
    return professionalAssociation;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setAdviserId(Integer adviserId) {
    this.adviserId = adviserId;
  }

  public void setProfessionalAssociation(ProfessionalAssociation professionalAssociation) {
    this.professionalAssociation = professionalAssociation;
  }
}
