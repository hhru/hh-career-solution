package ru.hh.career.solution.professionalenvironment.dao;

import org.hibernate.SessionFactory;
import ru.hh.career.solution.professionalenvironment.entity.ProfessionalEnvironment;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CheckerOnNullDAO extends GenericDao {

  @Inject
  public CheckerOnNullDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public boolean checkOnNullDAO() {
    CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
    CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
    Root<ProfessionalEnvironment> root = query.from(ProfessionalEnvironment.class);
    query.select(criteriaBuilder.count(root));
    long resultCount = getSession().createQuery(query).getSingleResult();
    return resultCount > 0;
  }
}
