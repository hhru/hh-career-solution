package ru.hh.career.solution.entity;

import ru.hh.career.solution.professionalenvironment.entity.Specialization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

  @Column(name = "account_id")
  private Integer accountId;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "account_id", insertable = false, updatable = false)
  private Account account;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "adviser_to_specialization"  ,
    joinColumns = @JoinColumn(name = "adviser_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id"))
  private Set<Specialization> specializationSet = new HashSet<>();

  @Column(name = "image_link")
  private String imageLink;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "area_id")
  private Area area;

  private String position;

  public Adviser() {
  }

  public Adviser(Integer id, String name, String surname, Consultation consultation, Experience experience,
                 CareerPractice careerPractice, CustomerType customerType, Integer accountId,
                 Set<Specialization> specializationSet, String imageLink, Area area, String position) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.consultation = consultation;
    this.experience = experience;
    this.careerPractice = careerPractice;
    this.customerType = customerType;
    this.accountId = accountId;
    this.specializationSet = specializationSet;
    this.imageLink = imageLink;
    this.area = area;
    this.position = position;
  }

  public Adviser(Integer id) {
    this.id = id;
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

  public Integer getAccountId() {
    return accountId;
  }

  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.accountId = account.getId();
    this.account = account;
  }

  public Set<Specialization> getSpecializationSet() {
    return specializationSet;
  }

  public void setSpecializationSet(Set<Specialization> specializationSet) {
    this.specializationSet = specializationSet;
  }

  public String getImageLink() {
    return imageLink;
  }

  public void setImageLink(String imageLink) {
    this.imageLink = imageLink;
  }

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }
}
