package ru.hh.career.solution.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import ru.hh.career.solution.ExampleResource;

@Configuration
@Import({
  CareerSecurityConfig.class,
  ExampleResource.class,
})
public class JerseyConfig {

  @Bean
  static public DelegatingFilterProxy delegatingFilterProxy(WebApplicationContext wac) {
    return new DelegatingFilterProxy("springSecurityFilterChain", wac);
  }
}
