package ru.hh.career.solution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.career.solution.ExampleResource;
import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.mapper.AdviserMapper;
import ru.hh.career.solution.resource.AdviserResource;
import ru.hh.career.solution.service.AdviserService;

@Configuration
@Import({
        ExampleResource.class,
        AdviserMapper.class,
        AdviserDao.class,
        AdviserService.class,
        AdviserResource.class,
})
public class JerseyConfig {
}
