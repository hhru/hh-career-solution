package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.CustomerProblemDto;
import ru.hh.career.solution.entity.CustomerProblem;

public class CustomerProblemMapper {

  public CustomerProblem toCustomerProblem(CustomerProblemDto customerProblemDto) {
    if (customerProblemDto == null) {
      return null;
    }
    return new CustomerProblem(
      customerProblemDto.getSpecializationId(),
      customerProblemDto.getConsultationType(),
      customerProblemDto.getExperience(),
      customerProblemDto.getCareerPractice(),
      customerProblemDto.getCustomerType()
    );
  }

  public CustomerProblemDto toCustomerProblemDto(CustomerProblem customerProblem) {
    if (customerProblem == null) {
      return null;
    }
    // TODO add area
    return new CustomerProblemDto(
      null,
      customerProblem.getSpecializationId(),
      customerProblem.getConsultationType(),
      customerProblem.getExperience(),
      customerProblem.getCareerPractice(),
      customerProblem.getCustomerType()
    );
  }
}
