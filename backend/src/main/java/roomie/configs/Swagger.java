package roomie.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Vasco Ramos
 * @created: 11/04/2021 - 18:22
 */

@Configuration
public class Swagger {
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.description}") String appDescription, @Value("${springdoc.version}") String appVersion) {
		return new OpenAPI().components(new Components())
		                    .info(new Info().title(appDescription).version(appVersion).description(appDescription)
		                                    .license(new License().name("MIT")
		                                                          .url("https://github.com/DxMonteiro/EAPRO/blob/main/LICENSE")));
	}
}

