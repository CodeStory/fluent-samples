package net.codestory;

import static net.codestory.AngularServer.*;

import net.codestory.http.*;
import net.codestory.http.misc.*;
import net.codestory.simplelenium.*;

import org.junit.*;

public class AngularTest extends SeleniumTest {
	static WebServer webServer = new WebServer() {
		@Override
		protected Env createEnv() {
			return Env.prod();
		}
	}.configure(new WebConfiguration()).startOnRandomPort();

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
