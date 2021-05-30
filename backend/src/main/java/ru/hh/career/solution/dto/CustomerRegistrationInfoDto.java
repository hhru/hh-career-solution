package ru.hh.career.solution.dto;

public class CustomerRegistrationInfoDto {

  private AccountDto account;
  private CustomerDto customer;

  public CustomerRegistrationInfoDto(AccountDto account, CustomerDto customer) {
    this.account = account;
    this.customer = customer;
  }

  public AccountDto getAccount() {
    return account;
  }

  public void setAccount(AccountDto account) {
    this.account = account;
  }

  public CustomerDto getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerDto customer) {
    this.customer = customer;
  }
}
