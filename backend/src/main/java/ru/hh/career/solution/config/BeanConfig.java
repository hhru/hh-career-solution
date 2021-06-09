package ru.hh.career.solution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.career.solution.area.dto.AreaParser;
import ru.hh.career.solution.area.service.ParserAreaService;
import ru.hh.career.solution.dao.AccountDao;
import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.dao.CustomerDao;
import ru.hh.career.solution.dao.GenericDao;
import ru.hh.career.solution.mapper.CustomerProblemMapper;
import ru.hh.career.solution.professionalenvironment.dto.ProfessionalEnvironmentParser;
import ru.hh.career.solution.professionalenvironment.services.ParserSpecializationService;
import ru.hh.career.solution.resource.AccountResource;
import ru.hh.career.solution.resource.AdviserResource;
import ru.hh.career.solution.resource.CustomerProblemResource;
import ru.hh.career.solution.resource.CustomerResource;
import ru.hh.career.solution.resource.ParserResource;
import ru.hh.career.solution.service.AccountService;
import ru.hh.career.solution.service.AdviserService;
import ru.hh.career.solution.service.CustomerService;

//import ru.hh.career.solution.professionalenvironment.dao.CheckerOnNullDao;
//import ru.hh.jclient.common.DefaultRequestStrategy;
//import ru.hh.jclient.common.HttpClientContext;
//import ru.hh.jclient.common.HttpClientFactory;
//import ru.hh.jclient.common.HttpClientFactoryBuilder;
//import ru.hh.jclient.common.util.storage.SingletonStorage;

@Configuration
@Import({
  AccountResource.class,
  AccountService.class,
  AccountDao.class,

  AdviserResource.class,
  AdviserService.class,
  AdviserDao.class,

  GenericDao.class,
  ParserSpecializationService.class,
  ParserResource.class,
  //CheckerOnNullDao.class,
  ProfessionalEnvironmentParser.class,


  ParserAreaService.class,
  AreaParser.class,

  CustomerProblemResource.class,
  CustomerProblemMapper.class,
  CustomerService.class,
  CustomerResource.class,
  CustomerDao.class,

})
public class BeanConfig {

//  @Bean
//  public HttpClientFactory httpClientFactory() throws IOException {
//    Properties jClientProperty = PropertiesUtils.fromFilesInSettingsDir("jclient.properties");
//    return new HttpClientFactoryBuilder(new SingletonStorage<>(() ->
//            new HttpClientContext(Map.of(), Map.of(), List.of())), List.of())
//            .withProperties(jClientProperty)
//            .withRequestStrategy(new DefaultRequestStrategy())
//            .withCallbackExecutor(Runnable::run)
//            .withHostsWithSession(Collections.singleton(jClientProperty != null ? jClientProperty
//                    .getProperty("jclient.hostsWithSession") : null))
//            .withUserAgent("my service")
//            .build();
//  }
}
