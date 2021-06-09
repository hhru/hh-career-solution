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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "customer_problem")
public class CustomerProblem {

  @Id
  @Column(name = "customer_problem_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "customer_id")
  private Integer customerId;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id", insertable = false, updatable = false)
  private Customer customer;

  // TODO add area reference
  // private Area area;

  @Column(name = "specialization_id")
  private Integer specializationId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "specialization_id", insertable = false, updatable = false)
  private Specialization specialization;

  @Column(name = "consultation_type")
  @Enumerated(EnumType.STRING)
  private Consultation consultationType;

  @Enumerated(EnumType.STRING)
  private Experience experience;

  @Column(name = "career_practice")
  @Enumerated(EnumType.STRING)
  private CareerPractice careerPractice;

  @Column(name = "customer_type")
  @Enumerated(EnumType.STRING)
  private CustomerType customerType;

  public CustomerProblem() {
  }

  public CustomerProblem(Integer specializationId, Consultation consultationType,
      Experience experience, CareerPractice careerPractice, CustomerType customerType) {
    this.specializationId = specializationId;
    this.consultationType = consultationType;
    this.experience = experience;
    this.careerPractice = careerPractice;
    this.customerType = customerType;
  }

  public CustomerProblem(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    setCustomerId(customer.getId());
    this.customer = customer;
  }

  public Integer getSpecializationId() {
    return specializationId;
  }

  public void setSpecializationId(Integer specializationId) {
    this.specializationId = specializationId;
  }

  public Specialization getSpecialization() {
    return specialization;
  }

  public void setSpecialization(Specialization specialization) {
    this.specialization = specialization;
  }

  public Consultation getConsultationType() {
    return consultationType;
  }

  public void setConsultationType(Consultation consultationType) {
    this.consultationType = consultationType;
  }

  public Experience getExperience() {
    return experience;
  }

  public void setExperience(Experience experience) {
    this.experience = experience;
  }

  public CareerPractice getCareerPractice() {
    return careerPractice;
  }

  public void setCareerPractice(CareerPractice careerPractice) {
    this.careerPractice = careerPractice;
  }

  public CustomerType getCustomerType() {
    return customerType;
  }

  public void setCustomerType(CustomerType customerType) {
    this.customerType = customerType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, specializationId, careerPractice, consultationType, customerType, experience);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    CustomerProblem other = (CustomerProblem) obj;
    return customerId.equals(other.customerId) && specializationId.equals(other.specializationId) && careerPractice == other.careerPractice
        && consultationType == other.consultationType && customerType == other.customerType
        && experience == other.experience;
  }
}
