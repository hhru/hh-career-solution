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

    public List<Adviser> getAllByProfessionalField(Integer professionalFieldId, Integer limit, Integer page) {
        return session()
                .getCurrentSession()
                .createQuery("SELECT a FROM Adviser a WHERE a.professional_field_id = :professionalFieldId " +
                        "ORDER BY a.id", Adviser.class)
                .setParameter("professionalFieldId", professionalFieldId)
                .setFirstResult(page*limit)
                .setMaxResults(limit)
                .getResultList();
    }

    public List<Adviser> getAllByArea(Integer areaId, Integer limit, Integer page) {
        return session()
                .getCurrentSession()
                .createQuery("SELECT a FROM Adviser a WHERE a.area_id = :areaId " +
                        "ORDER BY a.id", Adviser.class)
                .setParameter("areaId", areaId)
                .setFirstResult(page*limit)
                .setMaxResults(limit)
                .getResultList();
    }

    public List<Adviser> getAll(Integer limit, Integer page) {
        return session()
                .getCurrentSession()
                .createQuery("SELECT a FROM Adviser a ORDER BY a.id", Adviser.class)
                .setFirstResult(page*limit)
                .setMaxResults(limit)
                .getResultList();
    }

    public Optional<Adviser> get(Integer id) {
        return Optional.ofNullable(session().getCurrentSession().get(Adviser.class, id));
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

    public Long getCount() {
        return (Long) session()
                .getCurrentSession()
                .createQuery("SELECT count(*) FROM Adviser")
                .uniqueResult();
    }
}
