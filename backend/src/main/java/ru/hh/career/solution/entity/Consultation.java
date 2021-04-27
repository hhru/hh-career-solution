package ru.hh.career.solution.entity;

public enum Consultation {
  offline("offline"),
  online("online"),
  all("all");

  private final String description;

  private Consultation(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
