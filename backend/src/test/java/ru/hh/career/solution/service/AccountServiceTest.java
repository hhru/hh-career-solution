package ru.hh.career.solution.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.security.crypto.password.PasswordEncoder;

import ru.hh.career.solution.dao.AccountDao;
import ru.hh.career.solution.entity.Account;
import ru.hh.career.solution.exception.ErrorCode;
import ru.hh.career.solution.exception.LocalizableException;

public class AccountServiceTest {

  private static final String DEFAULT_USERNAME = "test username";
  private static final String DEFAULT_PASSWORD = "test password";
  private static final String DEFAULT_PASSWORD_HASH = "test password hash";

  private AutoCloseable mocks;

  @Mock
  AccountDao dao;

  @Mock
  PasswordEncoder encoder;

  AccountService service;

  @BeforeEach
  void beforeEach() {
    mocks = MockitoAnnotations.openMocks(this);
    service = new AccountService(dao, encoder);
  }

  @AfterEach
  void afterEach() throws Exception {
    mocks.close();
  }

  @Test
  void createUserShouldThrowLocalizableExceptionOnRegisteringAlreadyExistingUser() {
    when(dao.getByUsername(DEFAULT_USERNAME)).thenReturn(Optional.of(new Account()));
    try {
      service.createUser(DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }
    catch (LocalizableException e) {
      assertEquals(ErrorCode.USER_EXISTS_PRIOR_TO_REGISTRATION, e.getErrorCode());
    }
  }

  @Test
  void createUserShouldSaveAccountWithEncodedPassword() {
    when(dao.getByUsername(DEFAULT_USERNAME)).thenReturn(Optional.empty());
    when(encoder.encode(DEFAULT_PASSWORD)).thenReturn(DEFAULT_PASSWORD_HASH);
    doAnswer(new Answer<Account>() {
      @Override
      public Account answer(InvocationOnMock invocation) throws Throwable {
        Account account = ((Account) invocation.getArgument(0));
        assertEquals(DEFAULT_USERNAME, account.getUsername());
        assertEquals(DEFAULT_PASSWORD_HASH, account.getPasswordHash());
        return account;
      }
    }).when(dao).save(any());
    service.createUser(DEFAULT_USERNAME, DEFAULT_PASSWORD);
  }
}
