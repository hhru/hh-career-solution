package ru.hh.career.solution.area.dao;

import org.hibernate.SessionFactory;
import ru.hh.career.solution.area.entity.Area;
import ru.hh.career.solution.dao.GenericDao;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CheckerOnNullDao extends GenericDao {

  @Inject
  CheckerOnNullDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public boolean isAreaPresent() {
    CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
    CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
    Root<Area> root = query.from(Area.class);
    query.select(criteriaBuilder.count(root));
    long resultCount = getSession().createQuery(query).getSingleResult();
    return resultCount > 0;
  }
}
