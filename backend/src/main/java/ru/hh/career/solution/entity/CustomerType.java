package ru.hh.career.solution.entity;

public enum CustomerType {
  NO_EXPERIENCE("NO_EXPERIENCE"),
  SPECIALIST_AND_EXPERTS("SPECIALIST_AND_EXPERTS"),
  MIDDLE_MANAGEMENT("MIDDLE_MANAGEMENT"),
  TOP_MANAGEMENT("TOP_MANAGEMENT");

  private final String description;

  private CustomerType(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
