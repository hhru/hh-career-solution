package ru.hh.career.solution.service;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import ru.hh.career.solution.dao.AccountDao;
import ru.hh.career.solution.entity.Account;
import ru.hh.career.solution.exception.ErrorCode;
import ru.hh.career.solution.exception.LocalizableException;

public class AccountService {

  private final AccountDao dao;

  private final PasswordEncoder encoder;

  @Inject
  public AccountService(AccountDao dao, PasswordEncoder encoder) {
    this.dao = dao;
    this.encoder = encoder;
  }

  @Transactional
  public void createUser(String username, String password) {
    if (dao.getByUsername(username).isPresent()) {
      throw new LocalizableException(ErrorCode.USER_EXISTS_PRIOR_TO_REGISTRATION);
    }
    dao.save(new Account(username, encoder.encode(password)));
  }
}
