package ru.hh.career.solution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.mapper.AdviserMapper;
import ru.hh.career.solution.mapper.AreaMapper;
import ru.hh.career.solution.resource.AdviserResource;
import ru.hh.career.solution.service.AdviserService;

@Configuration
@EnableTransactionManagement
@Import({
  AdviserMapper.class,
  AdviserDao.class,
  AdviserService.class,
  AdviserResource.class,

  AreaMapper.class,
})
public class JerseyConfig {
}
