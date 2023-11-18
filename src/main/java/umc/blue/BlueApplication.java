package umc.blue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueApplication.class, args);
	}

}
