package net.codestory;

import net.codestory.http.WebServer;
import net.codestory.simplelenium.SeleniumTest;
import org.junit.Test;

public class HelloWorldTest extends SeleniumTest {
  WebServer webServer = new WebServer().startOnRandomPort();

  @Override
  public String getDefaultBaseUrl() {
    return "http://localhost:" + webServer.port();
  }

  @Test
  public void display_hello_world() {
    goTo("/");

    find(".jumbotron h1").should().contain("Hello, world!");
    find(".jumbotron p").should().contain("This is a very basic sample of web application");
  }
}
