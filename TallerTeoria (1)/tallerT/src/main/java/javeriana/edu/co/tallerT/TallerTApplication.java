package javeriana.edu.co.tallerT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "javeriana.edu.co.tallerT")
public class TallerTApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerTApplication.class, args);
	}

}
