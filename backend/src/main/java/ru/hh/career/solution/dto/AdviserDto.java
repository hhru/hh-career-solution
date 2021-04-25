package ru.hh.career.solution.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.hh.career.solution.entity.AdviserToEducational;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdviserDto {

  private Integer id;

  private String name;

  private String surname;

  private String consultation;

  private String experience;

  private String careerPractice;

  private String customerType;

  private String problemType;

  private LocalDateTime created;

  private LocalDateTime updated;

  private AreaDto area;

  private List<AdviserToEducational> educationalList;

  private List<ProfessionalSkillDto> professionalSkillList;

  private List<ProfessionalAssociationDto> professionalAssociationList;


  public AdviserDto() {
  }

  public AdviserDto(Integer id, String name, String surname, String consultation, String experience,
                    String careerPractice, String customerType, String problemType, LocalDateTime created,
                    LocalDateTime updated, AreaDto area, List<AdviserToEducational> educationalList,
                    List<ProfessionalSkillDto> professionalSkillList, List<ProfessionalAssociationDto> professionalAssociationList) {
    this.id = id;
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
    this.professionalSkillList = professionalSkillList;
    this.professionalAssociationList = professionalAssociationList;
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

  public List<ProfessionalSkillDto> getProfessionalSkillList() {
    return professionalSkillList;
  }

  public void setProfessionalSkillList(List<ProfessionalSkillDto> professionalSkillList) {
    this.professionalSkillList = professionalSkillList;
  }

  public List<ProfessionalAssociationDto> getProfessionalAssociationList() {
    return professionalAssociationList;
  }

  public void setProfessionalAssociationList(List<ProfessionalAssociationDto> professionalAssociationList) {
    this.professionalAssociationList = professionalAssociationList;
  }

  public AdviserDto clearExceptId() {
    this.name = null;
    this.surname = null;
    this.consultation = null;
    this.experience = null;
    this.careerPractice = null;
    this.customerType = null;
    this.problemType = null;
    this.created = null;
    this.updated = null;
    this.area = null;
    this.educationalList = null;
    this.professionalSkillList = null;
    this.professionalAssociationList = null;
    return this;
  }

}
