package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdviserDto {

  private Integer id;

  private String name;

  private String surname;

  private String consultation;

  private String experience;

  private String careerPractice;

  private String customerType;

  private Integer accountId;

  public AdviserDto() {
  }

  public AdviserDto(Integer id, String name, String surname, String consultation, String experience,
                    String careerPractice, String customerType) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.consultation = consultation;
    this.experience = experience;
    this.careerPractice = careerPractice;
    this.customerType = customerType;
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

  public Integer getAccountId() {
    return accountId;
  }

  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }
}
