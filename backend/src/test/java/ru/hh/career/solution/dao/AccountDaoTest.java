package ru.hh.career.solution.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.inject.Inject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import ru.hh.career.solution.HibernateTestConfig;
import ru.hh.career.solution.entity.Account;
import ru.hh.nab.testbase.hibernate.HibernateTestBase;

@ContextConfiguration(classes = AccountDaoTest.HibernateContextConfig.class)
public class AccountDaoTest extends HibernateTestBase {

  private static final String DEFAULT_USERNAME = "test username";

  @Inject
  AccountDao dao;

  @BeforeEach
  void beforeEach() {
    startTransaction();
  }

  @AfterEach
  void afterEach() {
    rollBackTransaction();
  }

  private static Account createTestAccount() {
    Account account = new Account();
    account.setUsername(DEFAULT_USERNAME);
    return account;
  }

  @Test
  void saveShouldSaveAccountToDb() {
    dao.save(createTestAccount());
    assertEquals(DEFAULT_USERNAME, getCurrentSession().get(Account.class, 1).getUsername());
  }

  @Test
  void getByUsernameShouldReturnValidOptional() {
    assertTrue(dao.getByUsername(DEFAULT_USERNAME).isEmpty());
    getCurrentSession().save(createTestAccount());
    assertTrue(dao.getByUsername(DEFAULT_USERNAME).isPresent());
  }

  @Configuration
  @Import({
    AccountDao.class,
    HibernateTestConfig.class,
  })
  public static class HibernateContextConfig {
  }
}
