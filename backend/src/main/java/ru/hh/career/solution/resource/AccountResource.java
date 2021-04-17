package ru.hh.career.solution.resource;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ru.hh.career.solution.exception.LocalizableException;
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
  public void signup(
      @NotBlank @FormParam("username") String username,
      @NotBlank @FormParam("password") String password) {
    try {
      service.createUser(username, password);
    }
    catch (LocalizableException e) {
      e.rethrowAsWebApplicationException();
    }
  }
}
