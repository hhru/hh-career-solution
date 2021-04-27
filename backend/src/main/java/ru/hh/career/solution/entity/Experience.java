package ru.hh.career.solution.entity;

public enum Experience {
  noExperience("noExperience"),
  between1And3("between1And3"),
  between3And6("between3And6"),
  moreThan6("moreThan6");

  private final String description;

  private Experience(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
