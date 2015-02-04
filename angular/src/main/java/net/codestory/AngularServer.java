package net.codestory;

import net.codestory.http.*;
import net.codestory.http.routes.*;

public class AngularServer {
	public static void main(String[] args) {
		new WebServer().configure(new WebConfiguration()).start();
	}

	public static class WebConfiguration implements Configuration {
		@Override
		public void configure(Routes routes) {
			routes.get("/hello/:name", (context, name) -> "Hello, " + name.toUpperCase() + "!");
		}
	}
}
