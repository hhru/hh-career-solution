package ru.hh.career.solution.service;

import org.springframework.transaction.annotation.Transactional;
import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.entity.Adviser;

import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Singleton
public class AdviserService {
  private final AdviserDao adviserDao;

  public AdviserService(AdviserDao adviserDao) {
    this.adviserDao = adviserDao;
  }

  @Transactional
  public List<Adviser> get(Integer limit, Integer page) {
    return adviserDao.get(limit, page);
  }

  @Transactional
  public Adviser getById(Integer adviserId) {
    return adviserDao.getById(adviserId).orElseThrow(NotFoundException::new);
  }

  @Transactional
  public Adviser create(Adviser adviser) {
    return adviserDao.create(adviser);
  }

  @Transactional
  public Adviser update(Adviser adviser) {
    return adviserDao.update(adviser);
  }

  @Transactional
  public Adviser saveOrUpdate(Adviser adviser) {
    return adviserDao.saveOrUpdate(adviser);
  }

  @Transactional()
  public Integer getPagesCount(Integer limit) {
    return (int) Math.ceil((double) adviserDao.getCount() / limit);
  }
}
