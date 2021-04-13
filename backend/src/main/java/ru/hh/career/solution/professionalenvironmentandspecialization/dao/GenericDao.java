package ru.hh.career.solution.professionalenvironmentandspecialization.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import java.io.Serializable;

public abstract class GenericDao {

    private final SessionFactory sessionFactory;

    @Inject
    protected GenericDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected void save(Object object) {
        if (object == null) {
            return;
        }
        getSession().save(object);
    }

    protected <T> T get(Class<T> clazz, Serializable id) {
        return getSession().get(clazz, id);
    }

    protected void update(Object object) {
        if (object == null) {
            return;
        }
        getSession().update(object);
    }

    protected void delete(Object object) {
        if (object == null) {
            return;
        }
        getSession().delete(object);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
