package flight.reservation.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import flight.reservation.springboot.services.ClientServiceImplementation;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories("flight.reservation.springboot.repository.ClientRepository")
public class FlightBooking {

	public static void main(String[] args) {
		SpringApplication.run(FlightBooking.class, args);
	}
	
	@Bean
	public ClientServiceImplementation csi() {
		return new ClientServiceImplementation();
	}

}
