package ru.hh.career.solution.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.common.properties.FileSettings;
import ru.hh.nab.datasource.DataSourceFactory;
import ru.hh.nab.hibernate.NabHibernateProdConfig;
import ru.hh.nab.starter.NabProdConfig;

import javax.sql.DataSource;

@Configuration
@Import({
    NabProdConfig.class,
    NabHibernateProdConfig.class,
})
public class ProdConfig {

  @Bean
  public DataSource dataSource(DataSourceFactory dataSourceFactory, FileSettings fileSettings) {
    return dataSourceFactory.create("master", false, fileSettings);
  }
}
