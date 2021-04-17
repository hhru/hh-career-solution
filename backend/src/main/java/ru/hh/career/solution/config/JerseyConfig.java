package ru.hh.career.solution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.nab.hibernate.NabHibernateCommonConfig;

@Configuration
@EnableTransactionManagement
@Import({
  BeanConfig.class,
  NabHibernateCommonConfig.class,
  AdviserMapper.class,
  AdviserDao.class,
  AdviserService.class,
  AdviserResource.class,

  AreaMapper.class,
})
public class JerseyConfig {
}
