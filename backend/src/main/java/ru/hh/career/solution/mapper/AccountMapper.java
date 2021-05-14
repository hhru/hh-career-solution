package ru.hh.career.solution.mapper;

import ru.hh.career.solution.entity.Account;

import java.util.Optional;

public class AccountMapper {

  public static Account mapToAccount(Integer id) {
    return Optional.ofNullable(id).map(Account::new).orElse(null);
  }
}
