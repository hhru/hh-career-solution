package ru.hh.career.solution.dao;

import java.util.Map;
import java.util.Optional;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import ru.hh.career.solution.entity.Customer;

public class CustomerDao extends GenericDao {

  @Inject
  public CustomerDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public Optional<Customer> getCustomerFromAccountId(Integer accountId) {
    return getSession().createQuery(selectWhereAllEqual(Customer.class, Map.of("accountId", accountId))).uniqueResultOptional();
  }
}
