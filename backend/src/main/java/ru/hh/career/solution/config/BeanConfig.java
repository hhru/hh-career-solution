package ru.hh.career.solution.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.career.solution.dao.AccountDao;
import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.professionalenvironment.dao.CheckerOnNullDAO;
import ru.hh.career.solution.professionalenvironment.dao.GenericDao;
import ru.hh.career.solution.professionalenvironment.dto.ProfessionalEnvironmentParser;
import ru.hh.career.solution.professionalenvironment.resource.ParserResource;
import ru.hh.career.solution.professionalenvironment.services.ParserSpecializationService;
import ru.hh.career.solution.resource.AccountResource;
import ru.hh.career.solution.resource.AdviserResource;
import ru.hh.career.solution.service.AccountService;
import ru.hh.career.solution.service.AdviserService;
import ru.hh.jclient.common.DefaultRequestStrategy;
import ru.hh.jclient.common.HttpClientContext;
import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.HttpClientFactoryBuilder;
import ru.hh.jclient.common.util.storage.SingletonStorage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Configuration
@Import({
  AccountResource.class,
  AccountService.class,
  AccountDao.class,

  AdviserResource.class,
  AdviserService.class,
  AdviserDao.class,

  ParserSpecializationService.class,
  ParserResource.class,
  GenericDao.class,
  CheckerOnNullDAO.class,
  ProfessionalEnvironmentParser.class
})
public class BeanConfig {

  @Bean
  public HttpClientFactory httpClientFactory(){
    String pathToProperties = "src/etc/hh-career-solution/jclient.properties";
    FileInputStream fileInputStream;
    Properties jClientProperty = new Properties();
    try {
      fileInputStream = new FileInputStream(pathToProperties);
      jClientProperty.load(fileInputStream);
    } catch (IOException e) {
      System.out.println("Ошибка в программе: файл " + pathToProperties + " не обнаружено");
      e.printStackTrace();
    }
    return new HttpClientFactoryBuilder(new SingletonStorage<>(() ->
            new HttpClientContext(Map.of(), Map.of(), List.of())), List.of())
            .withProperties(jClientProperty)
            .withRequestStrategy(new DefaultRequestStrategy())
            .withCallbackExecutor(Runnable::run)
            .withHostsWithSession(Collections.singleton(jClientProperty != null ? jClientProperty
                    .getProperty("jclient.hostsWithSession") : null))
            .withUserAgent("my service")
            .build();
  }
}
