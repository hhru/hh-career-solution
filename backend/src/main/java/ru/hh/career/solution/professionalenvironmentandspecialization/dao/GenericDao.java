package ru.hh.career.solution.professionalenvironmentandspecialization.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import java.io.Serializable;

public class GenericDao {

  private final SessionFactory sessionFactory;

  @Inject
  public GenericDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public void save(Object object) {
    if (object == null) {
      return;
    }
    getSession().save(object);
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

  public Session getSession() {
    return sessionFactory.getCurrentSession();
  }
}
