package ru.hh.career.solution.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "adviser")
public class Adviser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String surname;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "area_id")
  private Area area;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "adviser_to_professional_skill",
    joinColumns = @JoinColumn(name = "adviser_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "professional_skill_id", referencedColumnName = "id"))
  private Set<ProfessionalSkill> professionalSkillList = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "adviser_to_professional_association",
    joinColumns = @JoinColumn(name = "adviser_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "professional_association_id", referencedColumnName = "id"))
  private Set<ProfessionalAssociation> professionalAssociationList = new HashSet<>();

  private String consultation;

  private String experience;

  @Column(name = "career_practice", nullable = false)
  private String careerPractice;

  @Column(name = "customer_type", nullable = false)
  private String customerType;

  @Column(name = "problem_type", nullable = false)
  private String problemType;

  private LocalDateTime created;

  private LocalDateTime updated;

  public Adviser(Integer id, String name, String surname, Area area, Set<ProfessionalSkill> professionalSkillList,
                 Set<ProfessionalAssociation> professionalAssociationList, String consultation, String experience,
                 String careerPractice, String customerType, String problemType, LocalDateTime created, LocalDateTime updated) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.area = area;
    this.professionalSkillList = professionalSkillList;
    this.professionalAssociationList = professionalAssociationList;
    this.consultation = consultation;
    this.experience = experience;
    this.careerPractice = careerPractice;
    this.customerType = customerType;
    this.problemType = problemType;
    this.created = created;
    this.updated = updated;
  }

  public Adviser() {
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getConsultation() {
    return consultation;
  }

  public String getExperience() {
    return experience;
  }

  public String getCareerPractice() {
    return careerPractice;
  }

  public String getCustomerType() {
    return customerType;
  }

  public String getProblemType() {
    return problemType;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setConsultation(String consultation) {
    this.consultation = consultation;
  }

  public void setExperience(String experience) {
    this.experience = experience;
  }

  public void setCareerPractice(String careerPractice) {
    this.careerPractice = careerPractice;
  }

  public void setCustomerType(String customerType) {
    this.customerType = customerType;
  }

  public void setProblemType(String problemType) {
    this.problemType = problemType;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  public Set<ProfessionalSkill> getProfessionalSkillList() {
    return professionalSkillList;
  }

  public void setProfessionalSkillList(Set<ProfessionalSkill> professionalSkillList) {
    this.professionalSkillList = professionalSkillList;
  }

  public Set<ProfessionalAssociation> getProfessionalAssociationList() {
    return professionalAssociationList;
  }

  public void setProfessionalAssociationList(Set<ProfessionalAssociation> professionalAssociationList) {
    this.professionalAssociationList = professionalAssociationList;
  }
}
