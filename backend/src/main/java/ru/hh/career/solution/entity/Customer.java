package ru.hh.career.solution.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

  @Id
  @Column(name = "customer_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "account_id")
  private Integer accountId;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "account_id", insertable = false, updatable = false)
  private Account account;

  private String name;

  private String surname;

  @OneToMany(fetch = FetchType.LAZY)
  private List<CustomerProblem> customerProblems;

  public Customer() {
  }

  public Customer(Integer accountId, String name, String surname) {
    this.accountId = accountId;
    this.name = name;
    this.surname = surname;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAccountId() {
    return accountId;
  }

  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
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

  public List<CustomerProblem> getCustomerProblems() {
    return customerProblems;
  }

  public void setCustomerProblems(List<CustomerProblem> customerProblems) {
    this.customerProblems = customerProblems;
  }
}
