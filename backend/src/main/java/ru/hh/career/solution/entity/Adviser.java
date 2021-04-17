package ru.hh.career.solution.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "adviser")
public class Adviser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "surname", nullable = false)
  private String surname;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "area_id")
  private Area area;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "adviserId")
  //@JoinTable(name = "adviser_to_educational", joinColumns = @JoinColumn(columnDefinition = "adviser_id"))
  private List<AdviserToEducational> educationalList;

  @Column(name = "consultation", nullable = false)
  private String consultation;

  @Column(name = "experience", nullable = false)
  private String experience;

  @Column(name = "career_practice", nullable = false)
  private String careerPractice;

  @Column(name = "customer_type", nullable = false)
  private String customerType;

  @Column(name = "problem_type", nullable = false)
  private String problemType;

  @Column(name = "created")
  private LocalDateTime created;

  @Column(name = "updated")
  private LocalDateTime updated;

  public Adviser() {
  }

  public Adviser(Integer id, String name, String surname, String consultation, String experience,
                 String careerPractice, String customerType, String problemType,
                 LocalDateTime created, LocalDateTime updated) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.area = area;
    this.consultation = consultation;
    this.experience = experience;
    this.careerPractice = careerPractice;
    this.customerType = customerType;
    this.problemType = problemType;
    this.created = created;
    this.updated = updated;
  }

  public Adviser(Integer id, String name, String surname, Area area, List<AdviserToEducational> educationalList,
                 String consultation, String experience, String careerPractice, String customerType,
                 String problemType, LocalDateTime created, LocalDateTime updated) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.area = area;
    this.educationalList = educationalList;
    this.consultation = consultation;
    this.experience = experience;
    this.careerPractice = careerPractice;
    this.customerType = customerType;
    this.problemType = problemType;
    this.created = created;
    this.updated = updated;
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

  public List<AdviserToEducational> getEducationalList() {
    return educationalList;
  }

  public void setEducationalList(List<AdviserToEducational> educationalList) {
    this.educationalList = educationalList;
  }
}
