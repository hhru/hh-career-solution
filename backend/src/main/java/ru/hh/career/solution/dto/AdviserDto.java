package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import ru.hh.career.solution.entity.AdviserToEducational;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdviserDto {

  private Integer adviserId;

  private String name;

  private String surname;

  private String consultation;

  private String experience;

  private String careerPractice;

  private String customerType;

  private String problemType;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updated;

  private AreaDto area;

  private List<AdviserToEducational> educationalList;


  public AdviserDto() {
  }

  public AdviserDto(Integer adviserId, String name, String surname, String consultation, String experience,
                    String careerPractice, String customerType, String problemType, LocalDateTime created,
                    LocalDateTime updated, AreaDto area, List<AdviserToEducational> educationalList) {
    this.adviserId = adviserId;
    this.name = name;
    this.surname = surname;
    this.consultation = consultation;
    this.experience = experience;
    this.careerPractice = careerPractice;
    this.customerType = customerType;
    this.problemType = problemType;
    this.created = created;
    this.updated = updated;
    this.area = area;
    this.educationalList = educationalList;
  }

  public Integer getAdviserId() {
    return adviserId;
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

  public void setAdviserId(Integer adviserId) {
    this.adviserId = adviserId;
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

  public AreaDto getArea() {
    return area;
  }

  public void setArea(AreaDto area) {
    this.area = area;
  }

  public List<AdviserToEducational> getEducationalList() {
    return educationalList;
  }

  public void setEducationalList(List<AdviserToEducational> educationalList) {
    this.educationalList = educationalList;
  }
}
