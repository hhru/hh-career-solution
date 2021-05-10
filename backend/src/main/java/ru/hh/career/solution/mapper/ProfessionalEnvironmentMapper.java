package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.ProfessionalEnvironmentDto;
import ru.hh.career.solution.professionalenvironment.entity.ProfessionalEnvironment;

import javax.inject.Singleton;

@Singleton
public class ProfessionalEnvironmentMapper {

  public static ProfessionalEnvironment mapToProfessionalEnvironment(ProfessionalEnvironmentDto professionalEnvironmentDto) {
    return professionalEnvironmentDto == null ? null : new ProfessionalEnvironment(
      professionalEnvironmentDto.getId(),
      professionalEnvironmentDto.getName());
  }

  public static ProfessionalEnvironmentDto mapToProfessionalEnvironmentDto(ProfessionalEnvironment professionalEnvironment) {
    return professionalEnvironment == null ? null : new ProfessionalEnvironmentDto(
      professionalEnvironment.getId(),
      professionalEnvironment.getProfessionalEnvironmentName());
  }
}
