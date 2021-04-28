package ru.hh.career.solution.service;

import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.entity.Adviser;
import ru.hh.career.solution.exception.ErrorCode;
import ru.hh.career.solution.exception.LocalizableException;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

public class AdviserService {

  private final AdviserDao adviserDao;

  @Inject
  public AdviserService(AdviserDao adviserDao) {
    this.adviserDao = adviserDao;
  }

  @Transactional
  public List<Adviser> getAdvisers(Integer perPage, Integer page) {
    return adviserDao.getList(perPage, page);
  }

  @Transactional
  public Adviser getAdviserById(Integer adviserId) {
    return adviserDao.getById(adviserId)
      .orElseThrow(() -> new LocalizableException(ErrorCode.NOT_FOUND, Response.Status.NOT_FOUND));
  }

  public Integer getPagesCount(Long count, Integer perPage) {
    return (int) Math.ceil((double) count / perPage);
  }

  @Transactional
  public Long getCountAdvisers() {
    return adviserDao.getCount();
  }

  @Transactional
  public Adviser saveOrUpdate(Adviser adviser) {
    return (Adviser) adviserDao.saveOrUpdate(adviser);
  }
}
