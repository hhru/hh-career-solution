package ru.hh.career.solution.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.common.properties.FileSettings;
import ru.hh.nab.datasource.DataSourceFactory;
import ru.hh.nab.datasource.DataSourceType;
import ru.hh.nab.hibernate.MappingConfig;
import ru.hh.nab.hibernate.NabHibernateProdConfig;
import ru.hh.nab.starter.NabProdConfig;

import javax.sql.DataSource;

@Configuration
@Import({
  WebSecurityConfig.class,
  NabProdConfig.class,
  NabHibernateProdConfig.class,

})
public class ProdConfig {

  @Bean
  public MappingConfig mappingConfig() {
    MappingConfig mappingConfig = new MappingConfig();
    mappingConfig.addPackagesToScan("ru.hh.career.solution.entity");
    mappingConfig.addPackagesToScan("ru.hh.career.solution.professionalenvironment.entity");
    mappingConfig.addPackagesToScan("ru.hh.career.solution.area.entity");
    return mappingConfig;
  }

  @Bean
  public DataSource dataSource(DataSourceFactory dataSourceFactory, FileSettings fileSettings) {
    return dataSourceFactory.create(DataSourceType.MASTER, false, fileSettings);
  }
}
