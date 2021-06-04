package ru.hh.career.solution.resource;

import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.hh.career.solution.dto.CustomerDto;
import ru.hh.career.solution.dto.CustomerRegistrationInfoDto;
import ru.hh.career.solution.entity.Customer;
import ru.hh.career.solution.exception.ErrorCode;
import ru.hh.career.solution.exception.LocalizableException;
import ru.hh.career.solution.service.CustomerService;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

  private final CustomerService customerService;

  public CustomerResource(CustomerService customerService) {
    this.customerService = customerService;
  }

  @POST
  @Path("/signup")
  public void signup(CustomerRegistrationInfoDto customerInfo) {
    try {
      customerService.createCustomer(customerInfo);
    } catch (LocalizableException e) {
      throw e.asWebApplicationException();
    }
  }

  @GET
  @Path("/current")
  public CustomerDto getCurrentCustomer() {
    Optional<Customer> currentCustomer = customerService.getCurrentCustomer();
    if (currentCustomer.isPresent()) {
      return new CustomerDto(currentCustomer.get());
    }
    throw new LocalizableException(ErrorCode.NOT_FOUND, Response.Status.NOT_FOUND).asWebApplicationException();
  }
}
