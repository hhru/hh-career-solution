package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.SpecializationDto;
import ru.hh.career.solution.professionalenvironment.entity.Specialization;

public class SpecializationMapper {

  public static Specialization mapToSpecialization(SpecializationDto specializationDto) {
    return specializationDto == null ? null : new Specialization(
      specializationDto.getSpecializationId(),
      specializationDto.getName(),
      specializationDto.getLaboring(),
      ProfessionalEnvironmentMapper.mapToProfessionalEnvironment(specializationDto.getProfessionalEnvironment()));
  }

  public static SpecializationDto mapToSpecializationDto(Specialization specialization) {
    return specialization == null ? null : new SpecializationDto(
      specialization.getSpecializationId(),
      ProfessionalEnvironmentMapper.mapToProfessionalEnvironmentDto(specialization.getProfessionalEnvironment()),
      specialization.getSpecializationName(),
      specialization.getLaboring());
  }
}
