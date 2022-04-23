package codeChallenge.codeChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeChallengeApplication.class, args);
		System.out.println("started");
	}

	@GetMapping ("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "world") String name) {
		return String.format("Hello %s!", name);
	}

}
