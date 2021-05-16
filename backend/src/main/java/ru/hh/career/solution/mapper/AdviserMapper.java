package ru.hh.career.solution.mapper;

import java.util.Optional;
import java.util.stream.Collectors;
import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.dto.MatchingAdviserDto;
import ru.hh.career.solution.entity.Account;
import ru.hh.career.solution.entity.Adviser;
import ru.hh.career.solution.entity.CareerPractice;
import ru.hh.career.solution.entity.Consultation;
import ru.hh.career.solution.entity.CustomerType;
import ru.hh.career.solution.entity.Experience;

public class AdviserMapper {

  public static Adviser mapToAdviser(AdviserDto adviserDto, Integer accountId) {
    return adviserDto == null ? null : new Adviser(
      adviserDto.getId(),
      adviserDto.getName(),
      adviserDto.getSurname(),
      Consultation.valueOf(adviserDto.getConsultation()),
      Experience.valueOf(adviserDto.getExperience()),
      CareerPractice.valueOf(adviserDto.getCareerPractice()),
      CustomerType.valueOf(adviserDto.getCustomerType()),
      Optional.ofNullable(accountId).map(Account::new).orElse(null),
      adviserDto.getSpecializationList().stream().
        map(SpecializationMapper::mapToSpecialization).
        collect(Collectors.toSet()),
      adviserDto.getImageLink()
    );
  }

  public static AdviserDto mapToAdviserDto(Adviser adviser) {
    return adviser == null ? null : new AdviserDto(
      adviser.getId(),
      adviser.getName(),
      adviser.getSurname(),
      adviser.getConsultation().toString(),
      adviser.getExperience().toString(),
      adviser.getCareerPractice().toString(),
      adviser.getCustomerType().toString(),
      adviser.getSpecializationSet().stream().
        map(SpecializationMapper::mapToSpecializationDto).
        collect(Collectors.toList()),
      adviser.getImageLink()
    );
  }

  public static MatchingAdviserDto mapToMatchingAdviserDto(Adviser adviser) {
    return adviser == null ? null : new MatchingAdviserDto(
      adviser.getId(),
      adviser.getName(),
      adviser.getSurname(),
      adviser.getImageLink(),
      adviser.getExperience().toString(),
      adviser.getConsultation().toString(),
      adviser.getCareerPractice().toString()
    );
  }
}
