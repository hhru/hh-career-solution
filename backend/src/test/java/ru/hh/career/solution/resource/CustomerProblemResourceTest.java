package ru.hh.career.solution.resource;

import static javax.ws.rs.core.UriBuilder.fromResource;
import static javax.ws.rs.core.UriBuilder.fromUri;
import static javax.ws.rs.core.UriBuilder.fromPath;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.career.solution.TestConfig;
import ru.hh.career.solution.dto.CustomerProblemDto;
import ru.hh.career.solution.service.CustomerService;
import ru.hh.nab.starter.NabApplication;
import ru.hh.nab.testbase.ResourceHelper;
import ru.hh.nab.testbase.extensions.NabJunitWebConfig;
import ru.hh.nab.testbase.extensions.NabTestServer;
import ru.hh.nab.testbase.extensions.OverrideNabApplication;

@NabJunitWebConfig(CustomerProblemResourceTest.TestConfigWithMocks.class)
public class CustomerProblemResourceTest {

  private static final Class<CustomerProblemResource> RESOURCE = CustomerProblemResource.class;

  private static final String EMPTY_JSON = "{}";

  private static final String POST_PROBLEM_URL = fromResource(RESOURCE).toString();
  private static final String GET_PROBLEM_URL = fromResource(RESOURCE).path(RESOURCE, "getProblem").toString();
  private static final String GET_PROBLEM_MATCHES_URL = fromResource(RESOURCE).path(RESOURCE, "getProblemMatches").toString();

  @NabTestServer(overrideApplication = SpringCtxForJersey.class)
  ResourceHelper resourceHelper;

  AutoCloseable mocks;

  @Inject
  CustomerService service;

  @BeforeEach
  void beforeEach() {
    mocks = MockitoAnnotations.openMocks(this);
  }

  @AfterEach
  void afterEach() throws Exception {
    mocks.close();
  }

  @Test
  void postProblemShouldCallServiceAndReturnProblemLocation() throws InterruptedException, ExecutionException {
    final Integer problemId = 123;
    when(service.saveProblem(any(CustomerProblemDto.class))).thenReturn(problemId);
    Response response = resourceHelper.createRequest(POST_PROBLEM_URL).buildPost(Entity.json(EMPTY_JSON)).submit().get();
    verify(service, times(1)).saveProblem(any(CustomerProblemDto.class));
    assertEquals(response.getHeaderString("Location"), fromPath(resourceHelper.baseUrl()).path(GET_PROBLEM_URL).build(problemId).toString());
  }

  @Test
  void getProblemShouldCallService() {
    final Integer problemId = 123;
    resourceHelper.createRequest(fromUri(GET_PROBLEM_URL).build(problemId).toString()).get();
    verify(service, times(1)).getProblem(problemId);
  }

  @Test
  void getProblemMatchesShouldCallService() {
    final Integer problemId = 123;
    final Integer perPage = 3;
    final Integer page = 1;
    resourceHelper.createRequest(fromPath(GET_PROBLEM_MATCHES_URL)
        .queryParam("perPage", perPage).queryParam("page", page).build(problemId).toString()).get();
    verify(service, times(1)).getProblemMatches(problemId, perPage, page);
  }

  @Configuration
  @Import(CustomerProblemResource.class)
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
    public CustomerService accountService() {
      return mock(CustomerService.class);
    }
  }
}
