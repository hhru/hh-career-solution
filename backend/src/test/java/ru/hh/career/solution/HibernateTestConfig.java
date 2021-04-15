package ru.hh.career.solution;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import ru.hh.nab.common.properties.FileSettings;
import ru.hh.nab.datasource.DataSourceFactory;
import ru.hh.nab.datasource.DataSourceType;
import ru.hh.nab.hibernate.MappingConfig;
import ru.hh.nab.hibernate.NabHibernateCommonConfig;
import ru.hh.nab.testbase.hibernate.NabHibernateTestBaseConfig;

@Configuration
@Import({
  NabHibernateCommonConfig.class,
  NabHibernateTestBaseConfig.class,
})
public class HibernateTestConfig {

  private static final String DB_SETTINGS_FILE_NAME = "db-settings-test.properties";

  @Bean
  public MappingConfig mappingConfig() {
    MappingConfig mappingConfig = new MappingConfig();
    mappingConfig.addPackagesToScan("ru.hh.career.solution.entity");
    return mappingConfig;
  }

  @Bean
  public DataSource dataSource(DataSourceFactory dataSourceFactory, Properties dbProperties) {
    return dataSourceFactory.create(DataSourceType.MASTER, false, new FileSettings(dbProperties));
  }

  @Bean
  public PropertiesFactoryBean dbProperties() {
    PropertiesFactoryBean properties = new PropertiesFactoryBean();
    properties.setSingleton(false);
    properties.setIgnoreResourceNotFound(true);
    properties.setLocations(
        new ClassPathResource(DB_SETTINGS_FILE_NAME),
        new ClassPathResource(DB_SETTINGS_FILE_NAME + ".dev"));
    return properties;
  }
}
