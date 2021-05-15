package ru.hh.career.solution.dao;

import org.hibernate.SessionFactory;
import ru.hh.career.solution.entity.Adviser;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class AdviserDao extends GenericDao {

  @Inject
  public AdviserDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public List<Adviser> getList(Integer perPage, Integer page) {
    return getSession()
      .createQuery("SELECT a FROM Adviser a " +
        "LEFT JOIN FETCH a.specializationSet " +
        "ORDER BY a.id", Adviser.class)
      .setFirstResult(page * perPage)
      .setMaxResults(perPage)
      .getResultList();
  }

  public Optional<Adviser> getById(Integer id) {
    return getSession()
      .createQuery("SELECT a FROM Adviser a " +
        "LEFT JOIN FETCH a.specializationSet " +
        "WHERE a.id = :id", Adviser.class)
      .setParameter("id", id)
      .uniqueResultOptional();
  }

  public Long getCount() {
    return (Long) getSession()
      .createQuery("SELECT count(*) FROM Adviser")
      .uniqueResult();
  }
}
