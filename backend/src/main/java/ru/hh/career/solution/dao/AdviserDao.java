package ru.hh.career.solution.dao;

import org.hibernate.SessionFactory;
import ru.hh.career.solution.entity.Adviser;

import javax.inject.Inject;
import java.util.List;

public class AdviserDao extends GenericDao {

  @Inject
  public AdviserDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public List<Adviser> getList(Integer perPage, Integer page) {
    return getSession()
      .createQuery("SELECT a FROM Adviser a " +
        "LEFT JOIN FETCH a.area " +
        "LEFT JOIN FETCH a.educationalSet " +
        "LEFT JOIN FETCH a.professionalSkillSet " +
        "LEFT JOIN FETCH a.professionalAssociationSet " +
        "ORDER BY a.id", Adviser.class)
      .setFirstResult(page * perPage)
      .setMaxResults(perPage)
      .getResultList();
  }

  public Adviser getById(Integer id) {
    return getSession()
      .createQuery("SELECT a FROM Adviser a " +
        "LEFT JOIN FETCH a.area " +
        "LEFT JOIN FETCH a.educationalSet " +
        "LEFT JOIN FETCH a.professionalSkillSet " +
        "LEFT JOIN FETCH a.professionalAssociationSet " +
        "WHERE a.id = :id", Adviser.class)
      .setParameter("id", id)
      .getSingleResult();
  }

  public Long getCount() {
    return (Long) getSession()
      .createQuery("SELECT count(*) FROM Adviser")
      .uniqueResult();
  }

  public Adviser save(Adviser adviser) {
    getSession().save(adviser);
    return adviser;
  }

  public Adviser update(Adviser adviser) {
    getSession().update(adviser);
    return adviser;
  }

}
