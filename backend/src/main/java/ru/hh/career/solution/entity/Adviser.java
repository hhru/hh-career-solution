package ru.hh.career.solution.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adviser")
public class Adviser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String surname;

  @Enumerated(EnumType.STRING)
  private Consultation consultation;

  @Enumerated(EnumType.STRING)
  private Experience experience;

  @Column(name = "career_practice")
  @Enumerated(EnumType.STRING)
  private CareerPractice careerPractice;

  @Column(name = "customer_type")
  @Enumerated(EnumType.STRING)
  private CustomerType customerType;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "account_id")
  private Account account;

  public Adviser() {
  }

  public Adviser(Integer id, String name, String surname, Consultation consultation, Experience experience,
                 CareerPractice careerPractice, CustomerType customerType, Account account) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.consultation = consultation;
    this.experience = experience;
    this.careerPractice = careerPractice;
    this.customerType = customerType;
    this.account = account;
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

  public Consultation getConsultation() {
    return consultation;
  }

  public Experience getExperience() {
    return experience;
  }

  public CareerPractice getCareerPractice() {
    return careerPractice;
  }

  public CustomerType getCustomerType() {
    return customerType;
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

  public void setConsultation(Consultation consultation) {
    this.consultation = consultation;
  }

  public void setExperience(Experience experience) {
    this.experience = experience;
  }

  public void setCareerPractice(CareerPractice careerPractice) {
    this.careerPractice = careerPractice;
  }

  public void setCustomerType(CustomerType customerType) {
    this.customerType = customerType;
  }
}
