package ru.hh.career.solution.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Map;

@Primary
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

  protected <T> Predicate allEqual(Root<T> entity, Map<String, Object> entityFieldNamesToExpectedValues) {
    CriteriaBuilder cb = getSession().getCriteriaBuilder();
    return entityFieldNamesToExpectedValues.entrySet().stream()
      .map(nameToValue -> cb.equal(entity.get(nameToValue.getKey()), nameToValue.getValue()))
      .reduce(cb::and).orElseGet(cb::and);
  }

  protected <T> CriteriaQuery<T> selectWhereAllEqual(Class<T> clazz, Map<String, Object> entityFieldNamesToExpectedValues) {
    CriteriaQuery<T> query = getSession().getCriteriaBuilder().createQuery(clazz);
    return query.where(allEqual(query.from(clazz), entityFieldNamesToExpectedValues));
  }

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public void saveOrUpdate(Object object) {
    if (object == null) {
      return;
    }
    getSession().saveOrUpdate(object);
  }

  public <T> Long getCount(Class<T> clazz) {
    return getCount(clazz, Map.of());
  }

  public <T> Long getCount(Class<T> clazz, Map<String, Object> entityFieldNamesToExpectedValues) {
    CriteriaBuilder cb = getSession().getCriteriaBuilder();
    CriteriaQuery<Long> query = cb.createQuery(Long.class);
    Root<T> entity = query.from(clazz);
    query.select(cb.count(entity)).where(allEqual(entity, entityFieldNamesToExpectedValues));
    return getSession().createQuery(query).getSingleResult();
  }
}
