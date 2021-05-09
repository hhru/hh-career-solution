package ru.hh.career.solution.mapper;

import ru.hh.career.solution.professionalenvironment.dto.SpecializationDto;
import ru.hh.career.solution.professionalenvironment.entity.Specialization;

import javax.inject.Singleton;

@Singleton
public class SpecializationMapper {

  public static Specialization mapToSpecialization(SpecializationDto specializationDto) {
    return specializationDto == null ? null : new Specialization(
      specializationDto.getSpecializationId(),
      specializationDto.getName(),
      specializationDto.getLaboring(),
      ProfessionalEnvironmentMapper.mapToProfessionalEnvironment(specializationDto.getProfessionalEnvironmentId()));
  }

  public static SpecializationDto mapToSpecializationDto(Specialization specialization) {
    return specialization == null ? null : new SpecializationDto(
      specialization.getSpecializationId(),
      specialization.getProfessionalEnvironment().getId(),
      specialization.getSpecializationName(),
      specialization.getLaboring());
  }
}
