package flight.reservation.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import flight.reservation.springboot.model.PersonalDetails;

public interface ClientRepository extends JpaRepository<PersonalDetails, Long>{

	PersonalDetails findByName(String name);
}
