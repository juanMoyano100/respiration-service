package ucuenca.microservice.suenio.respiracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RespiracionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RespiracionServiceApplication.class, args);
	}

}
