package in.thewalker.gatekeeper.analytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.mongodb.autoconfigure.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class) // means we are excluding the MongoAutoConfiguration class from the auto-configuration process. This is useful when we don't want Spring Boot to automatically configure a MongoDB connection for us, for example, if we are not using a database in our application.
public class AnalyticsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsServiceApplication.class, args);
	}

}
