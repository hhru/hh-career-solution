package ru.hh.career.solution.resource;

import static javax.ws.rs.core.UriBuilder.fromResource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.databind.JsonNode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.career.solution.TestConfig;
import ru.hh.career.solution.exception.ErrorCode;
import ru.hh.career.solution.exception.LocalizableException;
import ru.hh.career.solution.resource.AccountResourceTest.TestConfigWithMocks;
import ru.hh.career.solution.service.AccountService;
import ru.hh.nab.starter.NabApplication;
import ru.hh.nab.testbase.ResourceHelper;
import ru.hh.nab.testbase.extensions.NabJunitWebConfig;
import ru.hh.nab.testbase.extensions.NabTestServer;
import ru.hh.nab.testbase.extensions.OverrideNabApplication;

@NabJunitWebConfig(TestConfigWithMocks.class)
public class AccountResourceTest {

  private static final String DEFAULT_USERNAME = "test username";
  private static final String DEFAULT_PASSWORD = "test password";
  private static final String SIGNUP_URL = fromResource(AccountResource.class).path(AccountResource.class, "signup").toString();

  @NabTestServer(overrideApplication = SpringCtxForJersey.class)
  ResourceHelper resourceHelper;

  AutoCloseable mocks;

  @Inject
  AccountService service;

  @BeforeEach
  void beforeEach() {
    mocks = MockitoAnnotations.openMocks(this);
  }

  @AfterEach
  void afterEach() throws Exception {
    mocks.close();
  }

  @Test
  void signupShouldDelegateFormParamsToServiceCreateUser() throws InterruptedException, ExecutionException {
    resourceHelper.createRequest(SIGNUP_URL).buildPost(Entity.form(new Form()
      .param("username", DEFAULT_USERNAME)
      .param("password", DEFAULT_PASSWORD))).submit().get();
    verify(service, times(1)).createUser(DEFAULT_USERNAME, DEFAULT_PASSWORD);
  }

  @Test
  void signupShouldReturn400WithCodeOnLozalizableException() throws InterruptedException, ExecutionException {
    doThrow(new LocalizableException(ErrorCode.USER_EXISTS_PRIOR_TO_REGISTRATION))
      .when(service).createUser(anyString(), anyString());
    Response response = resourceHelper.createRequest(SIGNUP_URL).buildPost(Entity.form(new Form()
      .param("username", DEFAULT_USERNAME)
      .param("password", DEFAULT_PASSWORD))).submit().get();
    assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    assertEquals(ErrorCode.USER_EXISTS_PRIOR_TO_REGISTRATION.ordinal(), response.readEntity(JsonNode.class).get("code").asInt());
  }

  @Configuration
  @Import(AccountResource.class)
  public static class SpringCtxForJersey implements OverrideNabApplication {

    @Override
    public NabApplication getNabApplication() {
      return NabApplication.builder().configureJersey(SpringCtxForJersey.class).bindToRoot().build();
    }
  }

  @Configuration
  @Import(TestConfig.class)
  public static class TestConfigWithMocks {

    @Bean
    public AccountService accountService() {
      return mock(AccountService.class);
    }
  }
}
