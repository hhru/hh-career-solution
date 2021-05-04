package ru.hh.career.solution.professionalenvironment.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.hh.jclient.common.DefaultRequestStrategy;
import ru.hh.jclient.common.HttpClientContext;
import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.HttpClientFactoryBuilder;
import ru.hh.jclient.common.Request;
import ru.hh.jclient.common.RequestBuilder;
import ru.hh.jclient.common.util.storage.SingletonStorage;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ParserProfessionalEnvironmentAndSpecialization {

  static final ObjectMapper mapper = new ObjectMapper();
  public static final String pathToProperties = "src/etc/hh-career-solution/jclient.properties";

  private Properties getjClientProperty() {
    FileInputStream fileInputStream;
    Properties properties = new Properties();
    try {
      fileInputStream = new FileInputStream(pathToProperties);
      properties.load(fileInputStream);
    } catch (IOException e) {
      System.out.println("Ошибка в программе: файл " + pathToProperties + " не обнаружено");
      e.printStackTrace();
    }
    return properties;
  }

  public ProfessionalEnvironmentDto[] parse()
          throws IOException, ExecutionException, InterruptedException {
    Properties jClientProperty = this.getjClientProperty();
    HttpClientFactory http = new HttpClientFactoryBuilder(new SingletonStorage<>(() ->
      new HttpClientContext(Map.of(), Map.of(), List.of())), List.of())
      .withProperties(jClientProperty)
      .withRequestStrategy(new DefaultRequestStrategy())
      .withCallbackExecutor(Runnable::run)
      .withHostsWithSession(Collections.singleton(jClientProperty != null ? jClientProperty
              .getProperty("jclient.hostsWithSession") : null))
      .withUserAgent("my service")
      .build();
    Request request = new RequestBuilder("GET").setUrl("https://api.hh.ru/specializations").build();
    CompletableFuture<ProfessionalEnvironmentDto[]> profEnvDTOFuture = http.with(request)
            .expectJson(mapper, ProfessionalEnvironmentDto[].class).result();
    return profEnvDTOFuture.get();
  }
}
