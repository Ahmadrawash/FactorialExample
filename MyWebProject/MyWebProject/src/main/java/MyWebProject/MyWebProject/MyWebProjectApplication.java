package MyWebProject.MyWebProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages={"MyWebProject.MyWebProject"})
@EntityScan("MyWebProject.MyWebProject.Models")
public class MyWebProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyWebProjectApplication.class, args);
		System.out.println("testing");

	}

}
