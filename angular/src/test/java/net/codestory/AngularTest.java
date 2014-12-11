package net.codestory;

import net.codestory.http.WebServer;
import net.codestory.simplelenium.SeleniumTest;
import org.junit.Test;

import static net.codestory.AngularServer.WebConfiguration;

public class AngularTest extends SeleniumTest {
  WebServer webServer = new WebServer().configure(WebConfiguration.class).startOnRandomPort();

  @Override
  public String getDefaultBaseUrl() {
    return "http://localhost:" + webServer.port();
  }

  @Test
  public void display_hello_world() {
    goTo("/");

    find("h1").should().contain("Hello, WORLD!");
  }

  @Test
  public void change_name() {
    goTo("/");

    find("#name").clear().fill("Bob");

    find("h1").should().contain("Hello, BOB!");
  }
}
