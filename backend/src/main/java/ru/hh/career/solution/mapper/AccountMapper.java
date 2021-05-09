package ru.hh.career.solution.mapper;

import ru.hh.career.solution.entity.Account;

import javax.inject.Singleton;

@Singleton
public class AccountMapper {

  public static Account mapToAccount(Integer id) {
    return id == null ? null : new Account(id);
  }
}
