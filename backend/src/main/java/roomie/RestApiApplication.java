package roomie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Collections;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RestApiApplication {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RestApiApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);
	}
}
