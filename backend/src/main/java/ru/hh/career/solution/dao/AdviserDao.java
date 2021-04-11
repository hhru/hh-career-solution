package ru.hh.career.solution.dao;

import org.hibernate.SessionFactory;
import ru.hh.career.solution.entity.Adviser;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class AdviserDao {

    private final SessionFactory sessionFactory;

    public AdviserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory session() {
        return sessionFactory;
    }

    public List<Adviser> getAll(Integer limit, Integer page) {
        return session()
                .getCurrentSession()
                .createQuery("SELECT f FROM Adviser f ORDER BY f.adviserId", Adviser.class)
                .setFirstResult(page*limit)
                .setMaxResults(limit)
                .getResultList();
    }

    public Optional<Adviser> get(Integer employerId) {
        return Optional.ofNullable(session().getCurrentSession().get(Adviser.class, employerId));
    }

    public Adviser update(Adviser adviser) {
        session().getCurrentSession().update(adviser);
        return adviser;
    }

    public Adviser create(Adviser adviser) {
        session().getCurrentSession().persist(adviser);
        return adviser;
    }

    public Adviser saveOrUpdate(Adviser adviser) {
        session().getCurrentSession().saveOrUpdate(adviser);
        return adviser;
    }

}
