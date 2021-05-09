package ru.hh.career.solution.mapper;

import ru.hh.career.solution.professionalenvironment.entity.ProfessionalEnvironment;

import javax.inject.Singleton;

@Singleton
public class ProfessionalEnvironmentMapper {

  public static ProfessionalEnvironment mapToProfessionalEnvironment(Integer id) {
    return id == null ? null : new ProfessionalEnvironment(id);
  }
}
