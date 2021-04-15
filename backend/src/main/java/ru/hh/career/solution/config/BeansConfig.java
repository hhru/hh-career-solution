package ru.hh.career.solution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.career.solution.ExampleResource;
import ru.hh.career.solution.dao.AccountDao;
import ru.hh.career.solution.resource.AccountResource;
import ru.hh.career.solution.service.AccountService;

@Configuration
@Import({
  ExampleResource.class,

  AccountResource.class,
  AccountService.class,
  AccountDao.class,
})
public class BeansConfig {
}
