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
@Table(name = "adviser_to_professional_skill")
public class AdviserToProfessionalSkill {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "adviser_id")
  private Integer adviserId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "professional_skill_id")
  private ProfessionalSkill professionalSkill;

  public AdviserToProfessionalSkill() {
  }

  public AdviserToProfessionalSkill(Integer id, Integer adviserId, ProfessionalSkill professionalSkill) {
    this.id = id;
    this.adviserId = adviserId;
    this.professionalSkill = professionalSkill;
  }

  public Integer getId() {
    return id;
  }

  public Integer getAdviserId() {
    return adviserId;
  }

  public ProfessionalSkill getProfessionalSkill() {
    return professionalSkill;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setAdviserId(Integer adviserId) {
    this.adviserId = adviserId;
  }

  public void setProfessionalSkill(ProfessionalSkill professionalSkill) {
    this.professionalSkill = professionalSkill;
  }
}
