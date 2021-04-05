package ru.hh.career.solution;

import org.springframework.web.filter.DelegatingFilterProxy;

import ru.hh.career.solution.config.JerseyConfig;
import ru.hh.career.solution.config.ProdConfig;
import ru.hh.nab.starter.NabApplication;

public class Main {

  public static void main(String[] args) {
    NabApplication
        .builder()
        .configureJersey(JerseyConfig.class)
        .bindToRoot()
        .addFilter(DelegatingFilterProxy.class)
        .bindToRoot()
        .build()
        .run(ProdConfig.class);
  }
}
