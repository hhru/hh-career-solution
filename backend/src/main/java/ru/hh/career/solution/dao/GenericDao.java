package ru.hh.career.solution.dao;

import java.io.Serializable;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDao {

  private final SessionFactory sessionFactory;

  @Inject
  public GenericDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * @return the generated identifier
   */
  public Serializable save(Object object) {
    if (object == null) {
      return null;
    }
    return getSession().save(object);
  }

  public <T> T get(Class<T> clazz, Serializable id) {
    return getSession().get(clazz, id);
  }

  public void update(Object object) {
    if (object == null) {
      return;
    }
    getSession().update(object);
  }

  public void delete(Object object) {
    if (object == null) {
      return;
    }
    getSession().delete(object);
  }

  protected <T> CriteriaQuery<T> selectWhereAllEqual(Class<T> clazz, Map<String, Object> entityFieldNamesToExpectedValues) {
    CriteriaBuilder cb = getSession().getCriteriaBuilder();
    CriteriaQuery<T> query = cb.createQuery(clazz);
    Root<T> entity = query.from(clazz);
    Predicate allEqual = entityFieldNamesToExpectedValues.entrySet().stream()
      .map(nameToValue -> cb.equal(entity.get(nameToValue.getKey()), nameToValue.getValue()))
      .reduce(cb::and).orElseGet(cb::and);
    return query.where(allEqual);
  }

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }
}
