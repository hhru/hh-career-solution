package ru.hh.career.solution.professionalenvironmentandspecialization.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;

public abstract class GenericDao {

    private final SessionFactory sessionFactory;

    @Inject
    protected GenericDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    protected void save(Object object) {
        if (object == null) {
            return;
        }
        getSession().save(object);
    }

    @Transactional
    protected <T> T get(Class<T> clazz, Serializable id) {
        return getSession().get(clazz, id);
    }

    @Transactional
    protected void update(Object object) {
        if (object == null) {
            return;
        }
        getSession().update(object);
    }

    @Transactional
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
