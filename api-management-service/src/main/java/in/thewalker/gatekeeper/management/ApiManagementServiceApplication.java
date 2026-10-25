package in.thewalker.gatekeeper.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

// @SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // means we are excluding the DataSourceAutoConfiguration class from the auto-configuration process. This is useful when we don't want Spring Boot to automatically configure a data source for us, for example, if we are not using a database in our application.
@SpringBootApplication
public class ApiManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiManagementServiceApplication.class, args);
	}

}
