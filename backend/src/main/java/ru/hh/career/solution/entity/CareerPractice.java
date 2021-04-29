package ru.hh.career.solution.entity;

public enum CareerPractice {
  CONSULTATION("CONSULTATION"),
  COACHING("COACHING"),
  ALL("ALL");

  private final String description;

  private CareerPractice(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
