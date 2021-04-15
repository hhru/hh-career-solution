package ru.hh.career.solution.resource;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ru.hh.career.solution.service.AccountService;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

  private final AccountService service;

  @Inject
  public AccountResource(AccountService service) {
    this.service = service;
  }

  @POST
  @Path("/signup")
  public Response signup(@FormParam("username") String username, @FormParam("password") String password) {
    service.createUser(username, password);
    return Response.ok().build();
  }
}
