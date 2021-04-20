package ru.hh.career.solution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.hh.nab.hibernate.NabHibernateCommonConfig;

@Configuration
@EnableTransactionManagement
@Import({
  BeanConfig.class,
  NabHibernateCommonConfig.class,
})
public class JerseyConfig {
}
