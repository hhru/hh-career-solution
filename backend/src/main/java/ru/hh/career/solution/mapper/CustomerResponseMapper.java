package ru.hh.career.solution.mapper;

import ru.hh.career.solution.entity.Adviser;
import ru.hh.career.solution.entity.CustomerProblem;
import ru.hh.career.solution.entity.CustomerResponse;

public class CustomerResponseMapper {

  public static CustomerResponse mapToCustomerResponse(Integer customerProblemId, Integer adviserId) {
    if ((customerProblemId == null) || (adviserId == null)) {
      return null;
    }

    return new CustomerResponse(
      new CustomerProblem(customerProblemId),
      new Adviser(adviserId));
  }
}
