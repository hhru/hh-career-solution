package ru.hh.career.solution.professionalenvironmentandspecialization.dao;

import org.hibernate.SessionFactory;
import ru.hh.career.solution.professionalenvironmentandspecialization.entity.ProfessionalEnvironmentEntity;

public class ProfessionalEnvironmentDao extends GenericDao{
    public ProfessionalEnvironmentDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void save(ProfessionalEnvironmentEntity professionalEnvironmentEntity) {
        super.save(professionalEnvironmentEntity);
    }

    public ProfessionalEnvironmentEntity get(Integer id) {
        return super.get(ProfessionalEnvironmentEntity.class, id);
    }

    public void update(ProfessionalEnvironmentEntity professionalEnvironmentEntity) {
        if (professionalEnvironmentEntity == null) {
            return;
        }
        getSession().update(professionalEnvironmentEntity);
    }

    public void delete(ProfessionalEnvironmentEntity professionalEnvironmentEntity) {
        if (professionalEnvironmentEntity == null) {
            return;
        }
        getSession().delete(professionalEnvironmentEntity);
    }
}
