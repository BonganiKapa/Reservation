package flight.reservation.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import flight.reservation.springboot.exception.ResourceNotFoundException;
import flight.reservation.springboot.model.PersonalDetails;
import flight.reservation.springboot.repository.ClientRepository;

@Service
@Transactional
@Primary
public class ClientServiceImplementation implements ClientServices {

	//@Autowired
	private ClientRepository cr;
	
	//@Override
	public PersonalDetails createClient(PersonalDetails client) {
		return cr.save(client);
	}

	//@Override
	public PersonalDetails updateClient(PersonalDetails client) {
		Optional <PersonalDetails> clientDB = this.cr.findById(client.getId());
		
		if(clientDB.isPresent()) {
			PersonalDetails clientUpdate = clientDB.get();
			clientUpdate.setId(client.getId());
			clientUpdate.setName(client.getName());
			clientUpdate.setSurname(client.getSurname());
			clientUpdate.setCell(client.getCell());
			clientUpdate.setPhone(client.getPhone());
			clientUpdate.setAddress(client.getAddress());
			cr.save(clientUpdate);
			return clientUpdate;
		}
		else {
			throw new ResourceNotFoundException("Record Not Found with ID : " + client.getId());
		}
		
	}

	//@Override
	public List<PersonalDetails> getClientList() {
		
		return this.cr.findAll();
	}

	//@Override
	public PersonalDetails getClientByID(long clientId) {
		
		Optional <PersonalDetails> clientDB = this.cr.findById(clientId);
		
		if(clientDB.isPresent()) {
			return clientDB.get();
		}
		else {
			throw new ResourceNotFoundException("Record Not Found with ID : " + clientId);
		}
		
	}

	//@Override
	public void deleteClient(long id) {
		
		Optional <PersonalDetails> clientDB = this.cr.findById(id);
		
		if(clientDB.isPresent()) {
			this.cr.delete(clientDB.get());
		}
	}

	//@Override
	public PersonalDetails getClientByEmail(String email) {
		return null;
	}
}
