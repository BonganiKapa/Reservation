package flight.reservation.springboot.services;

import java.util.List;

import flight.reservation.springboot.model.PersonalDetails;

public interface ClientServices {
	
	PersonalDetails createClient(PersonalDetails client);
	
	PersonalDetails updateClient(PersonalDetails client);
	
	List <PersonalDetails> getClientList();
	
	PersonalDetails getClientByEmail(String email);
	
	void deleteClient(long id);

}
