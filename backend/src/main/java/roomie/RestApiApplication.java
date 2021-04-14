package roomie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import roomie.helpers.FileUtils;

import java.util.Collections;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RestApiApplication {
	private static FileUtils fileUtils = new FileUtils();
	
	public static void main(String[] args) {
		fileUtils.init();
		SpringApplication app = new SpringApplication(RestApiApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);
	}
}
