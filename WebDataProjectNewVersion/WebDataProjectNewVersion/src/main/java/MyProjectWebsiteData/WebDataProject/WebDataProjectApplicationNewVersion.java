package MyProjectWebsiteData.WebDataProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages={"MyProjectWebsiteData.WebDataProject"})
@EntityScan("MyProjectWebsiteData.WebDataProject.Models")
public class WebDataProjectApplicationNewVersion {

	public static void main(String[] args) {
		SpringApplication.run(WebDataProjectApplicationNewVersion.class, args);
		System.out.println("testing");
	}

}
