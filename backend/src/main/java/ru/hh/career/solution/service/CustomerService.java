package ru.hh.career.solution.service;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.springframework.transaction.annotation.Transactional;
import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.dao.GenericDao;
import ru.hh.career.solution.entity.Adviser;
import ru.hh.career.solution.entity.CustomerProblem;
import ru.hh.career.solution.exception.ErrorCode;
import ru.hh.career.solution.exception.LocalizableException;

public class CustomerService {
  private final GenericDao genericDao;
  private final AdviserDao adviserDao;

  @Inject
  public CustomerService(GenericDao genericDao, AdviserDao adviserDao) {
    this.genericDao = genericDao;
    this.adviserDao = adviserDao;
  }

  @Transactional
  public Integer saveProblem(CustomerProblem customerProblem) {
    // TODO set customer from current session
    // customerProblem.setCustomer();
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
