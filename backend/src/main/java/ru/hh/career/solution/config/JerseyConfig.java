package ru.hh.career.solution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.nab.hibernate.NabHibernateCommonConfig;

@Configuration
@Import({
  BeansConfig.class,
  NabHibernateCommonConfig.class,
})
public class JerseyConfig {
}
