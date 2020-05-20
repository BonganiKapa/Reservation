package flight.reservation.springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import flight.reservation.springboot.model.PersonalDetails;

@Service
public interface ClientServices {
	
	PersonalDetails createClient(PersonalDetails client);
	
	PersonalDetails updateClient(PersonalDetails client);
	
	List <PersonalDetails> getClientList();
	
	PersonalDetails getClientByEmail(String email);
	
	void deleteClient(long id);

}
