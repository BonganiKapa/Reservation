package flight.reservation.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import flight.reservation.springboot.model.PersonalDetails;

@Repository
public interface ClientRepository extends JpaRepository<PersonalDetails, Long>{

	//Optional<PersonalDetails> findByName(String name);
}
