package ru.hh.career.solution.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.career.solution.ExampleResource;
import ru.hh.career.solution.exceptionmapper.LocalizableExceptionMapper;

@Configuration
@Import({
  ExampleResource.class,
})
public class JerseyConfig {

  static public void registerExceptionMappers(ResourceConfig config) {
    config.register(LocalizableExceptionMapper.class);
  }
}
