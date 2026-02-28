package yo.com.yo_catalog_service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "yo")
public class YoProperties {

	/**
	 * A message to welcome users.
	 */
	private String greeting;

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
