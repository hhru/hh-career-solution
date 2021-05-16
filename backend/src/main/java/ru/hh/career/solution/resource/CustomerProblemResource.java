package ru.hh.career.solution.resource;

import java.util.Map;
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
import ru.hh.career.solution.dto.CustomerProblemDto;
import ru.hh.career.solution.dto.PageResponseDto;
import ru.hh.career.solution.entity.Adviser;
import ru.hh.career.solution.service.CustomerService;

@Path("/customers/problems")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerProblemResource {

  private final CustomerService customerService;

  @Inject
  public CustomerProblemResource(CustomerService customerService) {
    this.customerService = customerService;
  }

  @POST
  public Response postProblem(CustomerProblemDto problem) {
    Integer problemId = customerService.saveProblem(problem);
    // problemId problem in json
    return Response.created(UriBuilder.fromResource(getClass()).path(getClass(), "getProblem").build(problemId))
      .entity(Map.of("problemId", problemId)).build();
  }

  @GET
  @Path("/{problemId:[\\d]+}")
  public CustomerProblemDto getProblem(@PathParam("problemId") Integer problemId) {
    return customerService.getProblem(problemId);
  }

  @GET
  @Path("/{problemId:[\\d]+}/matches")
  public PageResponseDto<Adviser> getProblemMatches(
      @PathParam("problemId") Integer problemId,
      @QueryParam("perPage") @DefaultValue("3") Integer perPage,
      @QueryParam("page") @DefaultValue("0") Integer page) {
    Long matchCount = customerService.getMatchCount(problemId);
    return new PageResponseDto<>(customerService.getProblemMatches(problemId, perPage, page), matchCount, perPage, page);
  }
}
