package ru.hh.career.solution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.career.solution.dao.AccountDao;
import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.resource.AccountResource;
import ru.hh.career.solution.resource.AdviserResource;
import ru.hh.career.solution.service.AccountService;
import ru.hh.career.solution.service.AdviserService;

@Configuration
@Import({
  AccountResource.class,
  AccountService.class,
  AccountDao.class,

  AdviserResource.class,
  AdviserService.class,
  AdviserDao.class,
})
public class BeanConfig {
}
