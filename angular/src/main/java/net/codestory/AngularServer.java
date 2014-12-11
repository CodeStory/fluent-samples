package net.codestory;

import net.codestory.http.Configuration;
import net.codestory.http.WebServer;
import net.codestory.http.routes.Routes;

public class AngularServer {
  public static void main(String[] args) {
    new WebServer().configure(WebConfiguration.class).start();
  }

  public static class WebConfiguration implements Configuration {
    @Override
    public void configure(Routes routes) {
      routes.get("/hello/:name", (context, name) -> "Hello, " + name.toUpperCase() + "!");
    }
  }
}
