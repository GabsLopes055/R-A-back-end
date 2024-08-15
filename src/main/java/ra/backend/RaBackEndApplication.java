package ra.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class RaBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaBackEndApplication.class, args);
	}

}
