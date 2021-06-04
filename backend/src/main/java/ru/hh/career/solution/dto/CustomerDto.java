package ru.hh.career.solution.dto;

import ru.hh.career.solution.entity.Customer;

public class CustomerDto {
  String name;
  String surname;

  public CustomerDto(Customer customer) {
    this(customer.getName(), customer.getSurname());
  }

  public CustomerDto(String name, String surname) {
    this.name = name;
    this.surname = surname;
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
}
