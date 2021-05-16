package ru.hh.career.solution.dto;

public class MatchingAdviserDto {

  private Integer id;

  private String name;

  private String surname;

  private String imageUrl;

  private String experience;

  private String consultationType;

  private String careerPractice;

  public MatchingAdviserDto(Integer id, String name, String surname, String imageUrl, String experience,
      String consultationType, String careerPractice) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.imageUrl = imageUrl;
    this.experience = experience;
    this.consultationType = consultationType;
    this.careerPractice = careerPractice;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getExperience() {
    return experience;
  }

  public void setExperience(String experience) {
    this.experience = experience;
  }

  public String getConsultationType() {
    return consultationType;
  }

  public void setConsultationType(String consultationType) {
    this.consultationType = consultationType;
  }

  public String getCareerPractice() {
    return careerPractice;
  }

  public void setCareerPractice(String careerPractice) {
    this.careerPractice = careerPractice;
  }
}
