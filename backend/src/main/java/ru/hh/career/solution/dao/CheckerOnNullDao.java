package ru.hh.career.solution.dao;

import org.hibernate.SessionFactory;
import ru.hh.career.solution.area.entity.Area;
import ru.hh.career.solution.professionalenvironment.entity.Specialization;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class CheckerOnNullDao extends GenericDao {

  @Inject
  public CheckerOnNullDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public boolean isSpecialisationsPresent() {
    return isTableNotEmpty(Specialization.class);
  }

  public boolean isAreaPresent() {
    return isTableNotEmpty(Area.class);
  }

  public boolean isTableNotEmpty(Class<?> clazz) {
    CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
    CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
    var root = query.from(clazz);
    query.select(criteriaBuilder.count(root));
    long resultCount = getSession().createQuery(query).getSingleResult();
    return resultCount > 0;
  }
}
