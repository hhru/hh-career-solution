package ru.hh.career.solution.resource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.dto.CustomerProblemDto;
import ru.hh.career.solution.dto.PageResponseDto;
import ru.hh.career.solution.exception.LocalizableException;
import ru.hh.career.solution.mapper.AdviserMapper;
import ru.hh.career.solution.mapper.CustomerProblemMapper;
import ru.hh.career.solution.service.CustomerService;

@Path("/customers/problems")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerProblemResource {

  private final CustomerService customerService;
  private final CustomerProblemMapper customerProblemMapper;

  @Inject
  public CustomerProblemResource(CustomerService customerService, CustomerProblemMapper customerProblemMapper) {
    this.customerService = customerService;
    this.customerProblemMapper = customerProblemMapper;
  }

  @POST
  public Response postProblem(CustomerProblemDto customerProblemDto) {
    Integer problemId = customerService.saveProblem(customerProblemMapper.toCustomerProblem(customerProblemDto));
    return Response.created(UriBuilder.fromResource(getClass()).path(getClass(), "getProblem").build(problemId))
      .entity(Map.of("problemId", problemId)).build();
  }

  @GET
  @Path("/{problemId:[\\d]+}")
  public CustomerProblemDto getProblem(@PathParam("problemId") Integer problemId) {
    try {
      return customerProblemMapper.toCustomerProblemDto(customerService.getProblem(problemId));
    } catch (LocalizableException e) {
      throw e.asWebApplicationException();
    }
  }

  @GET
  @Path("/{problemId:[\\d]+}/advisers/matches")
  public PageResponseDto<AdviserDto> getProblemMatches(
      @PathParam("problemId") Integer problemId,
      @QueryParam("perPage") @DefaultValue("3") Integer perPage,
      @QueryParam("page") @DefaultValue("0") Integer page) {
    try {
      Long matchCount = customerService.getMatchCount(problemId);
      List<AdviserDto> matches = customerService.getProblemMatches(problemId, perPage, page).stream()
          .map(AdviserMapper::mapToMatchingAdviserDto).collect(Collectors.toList());
      return new PageResponseDto<>(matches, matchCount, perPage, page);
    } catch (LocalizableException e) {
      throw e.asWebApplicationException();
    }
  }
}
