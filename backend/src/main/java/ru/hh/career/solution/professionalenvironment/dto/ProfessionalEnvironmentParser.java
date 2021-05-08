package ru.hh.career.solution.professionalenvironment.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.Request;
import ru.hh.jclient.common.RequestBuilder;

import java.util.concurrent.ExecutionException;


public class ProfessionalEnvironmentParser {

  static final ObjectMapper MAPPER = new ObjectMapper();
  private final HttpClientFactory http;

  public ProfessionalEnvironmentParser(HttpClientFactory http) {
    this.http = http;
  }

  public ProfessionalEnvironmentDto[] parse()
          throws ExecutionException, InterruptedException {

    Request request = new RequestBuilder("GET").setUrl("https://api.hh.ru/specializations").build();
    return http.with(request).expectJson(MAPPER, ProfessionalEnvironmentDto[].class).result().get();
  }
}
