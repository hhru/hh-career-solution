package ru.hh.career.solution.area.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.Request;
import ru.hh.jclient.common.RequestBuilder;

import java.util.concurrent.ExecutionException;

public class AreaParser {

  static final ObjectMapper MAPPER = new ObjectMapper();
  private final HttpClientFactory http;

  public AreaParser(HttpClientFactory http) {
    this.http = http;
  }

  public AreaDto[] parse() throws ExecutionException, InterruptedException {
    Request request = new RequestBuilder("GET").setUrl("https://api.hh.ru/areas").build();

    return http.with(request).expectJson(MAPPER, AreaDto[].class).result().get();
  }
}
