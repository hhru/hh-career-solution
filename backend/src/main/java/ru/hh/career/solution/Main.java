package ru.hh.career.solution;

import javax.servlet.Filter;

import ru.hh.career.solution.config.JerseyConfig;
import ru.hh.career.solution.config.ProdConfig;
import ru.hh.nab.starter.NabApplication;

public class Main {

  public static void main(String[] args) {
    NabApplication
        .builder()
        .addFilterBean(ctx -> (Filter) ctx.getBean("springSecurityFilterChain"))
        .bindToRoot()
        .configureJersey(JerseyConfig.class)
        .bindToRoot()
        .build()
        .run(ProdConfig.class);
  }
}
