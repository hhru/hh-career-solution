package ru.hh.career.solution;

import ru.hh.nab.testbase.extensions.NabJunitWebConfig;

@NabJunitWebConfig(TestConfig.class)
public class ExampleResourceTest {
  /*

  @NabTestServer(overrideApplication = SpringCtxForJersey.class)
  ResourceHelper resourceHelper;

  @Test
  public void hello() {
    final String name = "test";
    resourceHelper.assertGet(fromPath("/hello").queryParam("name", name).toString(), String.format("Hello, %s!", name));
  }

  @Test
  public void helloWithoutParams() {
    resourceHelper.assertGet(fromPath("/hello").toString(), "Hello, world!");
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
