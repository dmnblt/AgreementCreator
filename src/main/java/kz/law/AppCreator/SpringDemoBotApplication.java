package kz.law.AppCreator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoBotApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(SpringDemoBotApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
