package ru.hh.career.solution.service;

import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.entity.Adviser;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
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
    return adviserDao.getById(adviserId).orElseThrow(NotFoundException::new);
  }

  @Transactional
  public Integer getPagesCount(Integer limit) {
    return (int) Math.ceil((double) adviserDao.getCount() / limit);
  }

  @Transactional
  public Adviser save(Adviser adviser) {
    return adviserDao.save(adviser);
  }

  @Transactional
  public Adviser update(Adviser adviser) {
    return adviserDao.update(adviser);
  }
}
