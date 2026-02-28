package yo.com.yo_catalog_service;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yo.com.yo_catalog_service.config.YoProperties;

@RestController
public class HomeController {

	private final YoProperties yoProperties;

	public HomeController(YoProperties yoProperties) {
		this.yoProperties = yoProperties;
	}

	@GetMapping("/")
	public String getGreeting() {
		return yoProperties.getGreeting();
	}

}
