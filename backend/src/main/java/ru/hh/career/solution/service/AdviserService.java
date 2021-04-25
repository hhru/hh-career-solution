package ru.hh.career.solution.service;

import org.springframework.transaction.annotation.Transactional;
import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.entity.Adviser;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class AdviserService {
  private final AdviserDao adviserDao;

  public AdviserService(AdviserDao adviserDao) {
    this.adviserDao = adviserDao;
  }

  @Transactional
  public List<Adviser> getAdvisers(Integer perPage, Integer page) {
    return adviserDao.getList(perPage, page);
  }

  @Transactional
  public Adviser getAdviserById(Integer adviserId) {
    return adviserDao.getById(adviserId);
  }

  @Transactional()
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
