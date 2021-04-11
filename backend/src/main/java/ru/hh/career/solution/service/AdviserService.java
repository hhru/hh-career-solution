package ru.hh.career.solution.service;

import org.springframework.transaction.annotation.Transactional;
import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.entity.Adviser;

import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Singleton
public class AdviserService {
    private final AdviserDao adviserDao;

    public AdviserService(AdviserDao adviserDao) {
        this.adviserDao = adviserDao;
    }

    @Transactional
    public Adviser get(Integer adviserId) {
        return adviserDao.get(adviserId).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public List<Adviser> getAll(Integer limit, Integer page) {
        final int defaultLimit = 100;
        final int defaultPage = 0;
        limit = limit == null ? defaultLimit : limit;
        page = page == null ? defaultPage : page;

        return adviserDao.getAll(limit, page);
    }

    @Transactional
    public Adviser create(Adviser adviser) {
        return adviserDao.create(adviser);
    }

    @Transactional
    public Adviser saveOrUpdate(Adviser adviser) {
        return adviserDao.saveOrUpdate(adviser);
    }
}
