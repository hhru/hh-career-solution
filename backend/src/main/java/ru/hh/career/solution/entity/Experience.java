package ru.hh.career.solution.entity;

public enum Experience {
  NO_EXPERIENCE("NO_EXPERIENCE"),
  BETWEEN_1_AND_3("BETWEEN_1_AND_3"),
  BETWEEN_3_AND_6("BETWEEN_3_AND_6"),
  MORE_THAN_6("MORE_THAN_6");

  private final String description;

  private Experience(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
