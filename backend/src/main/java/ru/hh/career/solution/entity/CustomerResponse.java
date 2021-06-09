package ru.hh.career.solution.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_response")
public class CustomerResponse {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_problem_id")
  private CustomerProblem customerProblem;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "adviser_id")
  private Adviser adviser;

  private CustomerResponseState state;

  public CustomerResponse() {
  }

  public CustomerResponse(Integer id, CustomerProblem customerProblem, Adviser adviser, CustomerResponseState state) {
    this.id = id;
    this.customerProblem = customerProblem;
    this.adviser = adviser;
    this.state = state;
  }

  public CustomerResponse(CustomerProblem customerProblem, Adviser adviser) {
    this.customerProblem = customerProblem;
    this.adviser = adviser;
  }

  public Integer getId() {
    return id;
  }

  public CustomerProblem getCustomerProblem() {
    return customerProblem;
  }

  public Adviser getAdviser() {
    return adviser;
  }

  public CustomerResponseState getState() {
    return state;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setCustomerProblem(CustomerProblem customerProblem) {
    this.customerProblem = customerProblem;
  }

  public void setAdviser(Adviser adviser) {
    this.adviser = adviser;
  }

  public void setState(CustomerResponseState state) {
    this.state = state;
  }
}
