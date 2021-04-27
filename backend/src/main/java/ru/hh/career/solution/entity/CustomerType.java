package ru.hh.career.solution.entity;

public enum CustomerType {
  noExperience("noExperience"),
  specialistAndExperts("specialistAndExperts"),
  middleManagement("middleManagement"),
  topManagement("topManagement");

  private final String description;

  private CustomerType(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
