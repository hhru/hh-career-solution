package ru.hh.career.solution;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.nab.testbase.NabTestConfig;

@Configuration
@Import(NabTestConfig.class)
public class TestConfig {
}
