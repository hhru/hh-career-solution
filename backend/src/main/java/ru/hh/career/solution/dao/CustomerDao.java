package ru.hh.career.solution.dao;

import java.util.Map;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import ru.hh.career.solution.entity.Customer;

public class CustomerDao extends GenericDao {

  @Inject
  public CustomerDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public Customer getCustomerFromAccountId(Integer accountId) {
    return getSession().createQuery(selectWhereAllEqual(Customer.class, Map.of("accountId", accountId))).getSingleResult();
  }
}
