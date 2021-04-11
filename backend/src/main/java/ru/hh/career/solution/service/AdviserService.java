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
    public List<Adviser> getAllByProfessionalField(Integer professionalFieldId, Integer limit, Integer page) {
        return adviserDao.getAllByProfessionalField(professionalFieldId, limit, page);
    }

    @Transactional
    public List<Adviser> getAll(Integer limit, Integer page) {
        return adviserDao.getAll(limit, page);
    }

    @Transactional
    public List<Adviser> getAllByFilters(Integer limit, Integer page, Integer areaId, Integer professionalFieldsId) {

        return adviserDao.getAll(limit, page);
    }

    @Transactional
    public List<Adviser> getAllByArea(Integer areaId, Integer limit, Integer page) {
        return adviserDao.getAllByArea(areaId, limit, page);
    }

    @Transactional
    public Adviser create(Adviser adviser) {
        return adviserDao.create(adviser);
    }

    @Transactional
    public Adviser update(Adviser adviser) {
        return adviserDao.update(adviser);
    }

    @Transactional
    public Adviser saveOrUpdate(Adviser adviser) {
        return adviserDao.saveOrUpdate(adviser);
    }

    @Transactional()
    public Integer getPagesCount(Integer limit) {
        return (int) Math.ceil((double) adviserDao.getCount() / limit);
    }
}
