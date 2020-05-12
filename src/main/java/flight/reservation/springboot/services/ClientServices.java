package flight.reservation.springboot.services;

import java.util.List;

import flight.reservation.springboot.model.PersonalDetails;

public interface ClientServices {
	
	PersonalDetails createClient(PersonalDetails client);
	
	PersonalDetails updateClient(PersonalDetails client);
	
	List <PersonalDetails> getClientList();
	
	PersonalDetails getClientByID(long clientId);
	
	void deleteClient(long id);

}
