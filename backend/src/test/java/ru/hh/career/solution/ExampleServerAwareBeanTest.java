package ru.hh.career.solution;


import ru.hh.nab.testbase.extensions.NabJunitWebConfig;


@NabJunitWebConfig(TestConfig.class)
public class ExampleServerAwareBeanTest {
  /*

  @NabTestServer(overrideApplication = SpringCtxForJersey.class)
  ResourceHelper resourceHelper;

  @Test
  public void testBeanWithNabTestContext() {
    try (Response response = resourceHelper.createRequestFromAbsoluteUrl(resourceHelper.baseUrl() + "/hello").get()) {
      assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
      assertEquals("Hello, world!", response.readEntity(String.class));
    }
  }

  @Configuration
  @Import(ExampleResource.class)
  public static class SpringCtxForJersey implements OverrideNabApplication {
    @Override
    public NabApplication getNabApplication() {
      return NabApplication.builder().configureJersey(SpringCtxForJersey.class).bindToRoot().build();
    }
  }

   */
}
