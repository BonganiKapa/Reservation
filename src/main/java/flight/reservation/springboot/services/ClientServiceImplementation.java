package flight.reservation.springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import flight.reservation.springboot.model.PersonalDetails;
import flight.reservation.springboot.repository.ClientRepository;

@Service
@Transactional
public class ClientServiceImplementation implements ClientServices {

	private ClientRepository cr;
	public PersonalDetails createClient(PersonalDetails client) {
		// TODO Auto-generated method stub
		return null;
	}

	public PersonalDetails updateClient(PersonalDetails client) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PersonalDetails> getClientList() {
		// TODO Auto-generated method stub
		return null;
	}

	public PersonalDetails getClientByID(long clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteClient(long id) {
		// TODO Auto-generated method stub
		
	}

}
