package ru.hh.career.solution.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.transaction.annotation.Transactional;
import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.dao.GenericDao;
import ru.hh.career.solution.dto.CustomerProblemDto;
import ru.hh.career.solution.entity.Adviser;
import ru.hh.career.solution.entity.CustomerProblem;
import ru.hh.career.solution.mapper.CustomerProblemMapper;

public class CustomerService {
  private final GenericDao genericDao;
  private final AdviserDao adviserDao;
  private final CustomerProblemMapper customerProblemMapper;

  @Inject
  public CustomerService(GenericDao genericDao, AdviserDao adviserDao, CustomerProblemMapper customerProblemMapper) {
    this.genericDao = genericDao;
    this.adviserDao = adviserDao;
    this.customerProblemMapper = customerProblemMapper;
  }

  @Transactional
  public Integer saveProblem(CustomerProblemDto customerProblemDto) {
    CustomerProblem customerProblem = customerProblemMapper.toEntity(customerProblemDto);
    // TODO set customer from current session
    // customerProblem.setCustomer();
    return (Integer) genericDao.save(customerProblem);
  }

  @Transactional
  public CustomerProblemDto getProblem(Integer problemId) {
    return customerProblemMapper.toDto(genericDao.get(CustomerProblem.class, problemId));
  }

  @Transactional
  public Long getMatchCount(Integer problemId) {
    return adviserDao.getMatchCount(genericDao.get(CustomerProblem.class, problemId));
  }

  @Transactional
  public List<Adviser> getProblemMatches(Integer problemId, Integer perPage, Integer page) {
    return adviserDao.getMatchingAdvisers(genericDao.get(CustomerProblem.class, problemId), page * perPage, perPage);
  }
}
