package ru.hh.career.solution.entity;

public enum Consultation {
  OFFLINE("OFFLINE"),
  ONLINE("ONLINE"),
  ALL("ALL");

  private final String description;

  private Consultation(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
