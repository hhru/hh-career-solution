package ru.hh.career.solution.dao;

import org.hibernate.SessionFactory;
import ru.hh.career.solution.entity.Adviser;
import ru.hh.career.solution.entity.CareerPractice;
import ru.hh.career.solution.entity.Consultation;
import ru.hh.career.solution.entity.CustomerProblem;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class AdviserDao extends GenericDao {

  @Inject
  public AdviserDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public List<Adviser> getListWithFetchedFields(Integer perPage, Integer page) {
    return getSession()
      .createQuery("SELECT a FROM Adviser a " +
        "LEFT JOIN FETCH a.specializationSet " +
        "LEFT JOIN FETCH a.area " +
        "ORDER BY a.id", Adviser.class)
      .setFirstResult(page * perPage)
      .setMaxResults(perPage)
      .getResultList();
  }

  public Optional<Adviser> getByIdWithFetchedFields(Integer id) {
    return getSession()
      .createQuery("SELECT a FROM Adviser a " +
        "LEFT JOIN FETCH a.specializationSet " +
        "LEFT JOIN FETCH a.area " +
        "WHERE a.id = :id", Adviser.class)
      .setParameter("id", id)
      .uniqueResultOptional();
  }

  public Long getCount() {
    return (Long) getSession()
      .createQuery("SELECT count(*) FROM Adviser")
      .uniqueResult();
  }

  protected Predicate matches(Root<Adviser> adviser, CustomerProblem customerProblem) {
    CriteriaBuilder cb = getSession().getCriteriaBuilder();
    Predicate specializationMatches = cb.isMember(customerProblem.getSpecialization(), adviser.get("specializationSet"));
    Predicate consultationTypeMatches = adviser.get("consultation").in(Consultation.ALL, customerProblem.getConsultationType());
    Predicate careerPracticeMatches = adviser.get("careerPractice").in(CareerPractice.ALL, customerProblem.getCareerPractice());
    Predicate customerTypeMatches = cb.equal(adviser.get("customerType"), customerProblem.getCustomerType());
    Predicate experienceMatches = cb.equal(adviser.get("experience"), customerProblem.getExperience());
    Predicate adviserMatches = cb.and(specializationMatches, consultationTypeMatches, experienceMatches,
        careerPracticeMatches, customerTypeMatches);
    return adviserMatches;
  }

  public List<Adviser> getMatchingAdvisers(CustomerProblem customerProblem, Integer firstResult, Integer maxResult) {
    CriteriaBuilder cb = getSession().getCriteriaBuilder();
    CriteriaQuery<Adviser> query = cb.createQuery(Adviser.class);
    Root<Adviser> adviser = query.from(Adviser.class);
    return getSession().createQuery(query.select(adviser).where(matches(adviser, customerProblem)))
          .setFirstResult(firstResult)
          .setMaxResults(maxResult)
          .getResultList();
  }

  public Long getMatchCount(CustomerProblem customerProblem) {
    CriteriaBuilder cb = getSession().getCriteriaBuilder();
    CriteriaQuery<Long> query = cb.createQuery(Long.class);
    Root<Adviser> adviser = query.from(Adviser.class);
    query.select(cb.count(adviser)).where(matches(adviser, customerProblem));
    return getSession().createQuery(query).getSingleResult();
  }
}
