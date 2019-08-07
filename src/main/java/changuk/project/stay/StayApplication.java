package changuk.project.stay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class StayApplication {

	public static void main(String[] args) {
		SpringApplication.run(StayApplication.class, args);
	}

}
