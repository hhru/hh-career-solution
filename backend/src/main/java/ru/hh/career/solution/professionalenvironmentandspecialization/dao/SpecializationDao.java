package ru.hh.career.solution.professionalenvironmentandspecialization.dao;

import org.hibernate.SessionFactory;
import ru.hh.career.solution.professionalenvironmentandspecialization.entity.SpecializationEntity;

import javax.inject.Inject;

public class SpecializationDao extends GenericDao {
    @Inject
    public SpecializationDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void save(SpecializationEntity specializationEntity) {
        super.save(specializationEntity);
    }

    public SpecializationEntity get(Integer id) {
        return super.get(SpecializationEntity.class, id);
    }

    public void update(SpecializationEntity specializationEntity) {
        if (specializationEntity == null) {
            return;
        }
        getSession().update(specializationEntity);
    }

    public void delete(SpecializationEntity specializationEntity) {
        if (specializationEntity != null) {
            getSession().delete(specializationEntity);
        }
    }
}
