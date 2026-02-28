package yo.com.yo_catalog_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class YoCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoCatalogServiceApplication.class, args);
	}

}
