package ru.hh.career.solution.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.career.solution.ExampleResource;
import ru.hh.nab.hibernate.MappingConfig;

@Configuration
@Import({
        ExampleResource.class,
})
public class JerseyConfig {

    @Bean
    public MappingConfig mappingConfig() {
        MappingConfig mappingConfig = new MappingConfig();
        mappingConfig.addPackagesToScan("ru.hh.career.solution.entity");
        return mappingConfig;
    }
}
