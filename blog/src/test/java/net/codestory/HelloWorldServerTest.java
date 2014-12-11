package net.codestory;

import net.codestory.http.WebServer;
import net.codestory.simplelenium.SeleniumTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldServerTest extends SeleniumTest {
  static WebServer webServer = new WebServer().startOnRandomPort();

  @Override
  protected String getDefaultBaseUrl() {
    return "http://localhost:" + webServer.port();
  }

  @Test
  public void archives() {
    goTo("/");

    find("#archives a").should()
      .haveSize(3)
      .contain("A nice Lorem ipsum", "Yet another Lorem ipsum", "And again");
  }

  @Test
  public void tags() {
    goTo("/");

    find("#tags #coffee").should().haveSize(1);
    find("#tags #java").should().haveSize(1);
  }

  @Test
  public void post() {
    goTo("/");

    find("a").withText("A nice Lorem ipsum").click();

    find(".panel-heading").should().contain("A nice Lorem ipsum");
    find(".panel-body").should().contain("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
  }

  @Test
  public void from_post_to_index() {
    goTo("/posts/first");

    find("a").withText("Back to index").click();

    assertThat(path()).isEqualTo("/");
  }
}