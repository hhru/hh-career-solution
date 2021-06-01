package ru.hh.career.solution.service;

import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.springframework.transaction.annotation.Transactional;
import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.dao.CustomerDao;
import ru.hh.career.solution.dao.GenericDao;
import ru.hh.career.solution.dto.CustomerRegistrationInfoDto;
import ru.hh.career.solution.entity.Account;
import ru.hh.career.solution.entity.Adviser;
import ru.hh.career.solution.entity.Customer;
import ru.hh.career.solution.entity.CustomerProblem;
import ru.hh.career.solution.exception.ErrorCode;
import ru.hh.career.solution.exception.LocalizableException;

public class CustomerService {
  private final GenericDao genericDao;
  private final AdviserDao adviserDao;
  private final CustomerDao customerDao;
  private final AccountService accountService;

  @Inject
  public CustomerService(GenericDao genericDao, AdviserDao adviserDao, CustomerDao customerDao, AccountService accountService) {
    this.genericDao = genericDao;
    this.adviserDao = adviserDao;
    this.customerDao = customerDao;
    this.accountService = accountService;
  }

  @Transactional
  public void createCustomer(CustomerRegistrationInfoDto info) {
    Integer accountId = accountService.createUser(info.getAccount().getUsername(), info.getAccount().getPassword());
    genericDao.save(new Customer(accountId, info.getCustomer().getName(), info.getCustomer().getSurname()));
  }

  @Transactional
  public Customer getCustomer(Integer id) {
    return genericDao.get(Customer.class, id);
  }

  @Transactional
  public Optional<Customer> getCurrentCustomer() {
    Optional<Account> currentAccount = accountService.getCurrentAccount();
    if (currentAccount.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(customerDao.getCustomerFromAccountId(currentAccount.get().getId()));
  }

  @Transactional
  public Integer saveProblem(CustomerProblem customerProblem) {
    Optional<Customer> currentCustomer = getCurrentCustomer();
    if (currentCustomer.isEmpty()) {
      throw new LocalizableException(ErrorCode.CUSTOMER_SHOULD_BE_AUTHENTICATED_TO_SAVE_PROBLEM, Response.Status.UNAUTHORIZED);
    }
    customerProblem.setCustomer(currentCustomer.get());
    return (Integer) genericDao.save(customerProblem);
  }

  @Transactional
  public CustomerProblem getProblem(Integer problemId) throws LocalizableException {
    CustomerProblem customerProblem = genericDao.get(CustomerProblem.class, problemId);
    if (customerProblem == null) {
      throw new LocalizableException(ErrorCode.NOT_FOUND, Response.Status.NOT_FOUND);
    }
    return customerProblem;
  }

  @Transactional
  public Long getMatchCount(Integer problemId) {
    return adviserDao.getMatchCount(getProblem(problemId));
  }

  @Transactional
  public List<Adviser> getProblemMatches(Integer problemId, Integer perPage, Integer page) {
    return adviserDao.getMatchingAdvisers(getProblem(problemId), page * perPage, perPage);
  }
}
