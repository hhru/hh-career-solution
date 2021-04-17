package ru.hh.career.solution.dao;

import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

import ru.hh.career.solution.entity.Account;

public class AccountDao extends GenericDao {

  @Inject
  public AccountDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public Optional<Account> getByUsername(String username) {
    return getSession().createQuery(selectWhereAllEqual(Account.class, Map.of("username", username))).uniqueResultOptional();
  }
}
