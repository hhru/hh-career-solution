package ru.hh.career.solution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.career.solution.ExampleResource;

@Configuration
@Import({
    ExampleResource.class,
})
public class JerseyConfig {
}
