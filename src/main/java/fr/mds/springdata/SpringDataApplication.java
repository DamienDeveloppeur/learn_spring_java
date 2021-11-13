package fr.mds.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import fr.mds.springdata.domain.Animal;
import fr.mds.springdata.domain.Specie;
import fr.mds.springdata.service.TestService;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("fr.mds")
@Configuration
public class SpringDataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataApplication.class, args);
	}

}
