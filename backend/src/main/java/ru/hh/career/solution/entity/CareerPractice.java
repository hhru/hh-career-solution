package ru.hh.career.solution.entity;

public enum CareerPractice {
  consultation("consultation"),
  coaching("coaching"),
  all("all");

  private final String description;

  private CareerPractice(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
