package ru.hh.career.solution;

import ru.hh.career.solution.config.JerseyConfig;
import ru.hh.career.solution.config.ProdConfig;
import ru.hh.nab.starter.NabApplication;

import javax.servlet.Filter;

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
