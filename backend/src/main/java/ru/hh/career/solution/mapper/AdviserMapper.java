package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.entity.Account;
import ru.hh.career.solution.entity.Adviser;
import ru.hh.career.solution.entity.CareerPractice;
import ru.hh.career.solution.entity.Consultation;
import ru.hh.career.solution.entity.CustomerType;
import ru.hh.career.solution.entity.Experience;

import javax.inject.Singleton;

@Singleton
public class AdviserMapper {

  public static Adviser mapToAdviser(AdviserDto adviserDto) {
    return adviserDto == null ? null : new Adviser(
      adviserDto.getId(),
      adviserDto.getName(),
      adviserDto.getSurname(),
      Consultation.valueOf(adviserDto.getConsultation()),
      Experience.valueOf(adviserDto.getExperience()),
      CareerPractice.valueOf(adviserDto.getCareerPractice()),
      CustomerType.valueOf(adviserDto.getCustomerType()),
      new Account(adviserDto.getAccountId()));
  }

  public static AdviserDto mapToAdviserDto(Adviser adviser) {
    return adviser == null ? null : new AdviserDto(
      adviser.getId(),
      adviser.getName(),
      adviser.getSurname(),
      adviser.getConsultation().toString(),
      adviser.getExperience().toString(),
      adviser.getCareerPractice().toString(),
      adviser.getCustomerType().toString());
  }
}
