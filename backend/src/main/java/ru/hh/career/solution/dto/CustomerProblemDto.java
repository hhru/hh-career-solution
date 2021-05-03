package ru.hh.career.solution.dto;

import ru.hh.career.solution.entity.CareerPractice;
import ru.hh.career.solution.entity.Consultation;
import ru.hh.career.solution.entity.CustomerType;
import ru.hh.career.solution.entity.Experience;

public class CustomerProblemDto {

  private Integer areaId;

  private Integer specializationId;

  private Consultation consultationType;

  private Experience experience;

  private CareerPractice careerPractice;

  private CustomerType customerType;

  public CustomerProblemDto() {
  }

  public CustomerProblemDto(Integer areaId, Integer specializationId, Consultation consultationType,
      Experience experience, CareerPractice careerPractice, CustomerType customerType) {
    this.areaId = areaId;
    this.specializationId = specializationId;
    this.consultationType = consultationType;
    this.experience = experience;
    this.careerPractice = careerPractice;
    this.customerType = customerType;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public Integer getSpecializationId() {
    return specializationId;
  }

  public void setSpecializationId(Integer specializationId) {
    this.specializationId = specializationId;
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
}
