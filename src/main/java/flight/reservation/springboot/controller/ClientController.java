package flight.reservation.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import flight.reservation.springboot.model.PersonalDetails;
import flight.reservation.springboot.services.ClientServices;

@RestController
public class ClientController {
	
	@Autowired
	private ClientServices cs;
	
	@GetMapping("/client")
	public ResponseEntity <PersonalDetails> registerClient(@RequestBody PersonalDetails client){
		return ResponseEntity.ok().body(this.cs.createClient(client));
	}
	
	@PutMapping("/client/{idNum}")
	public ResponseEntity <PersonalDetails> updateClient(@PathVariable String idNum, @RequestBody PersonalDetails client){
		client.setIdNm(idNum);
		return ResponseEntity.ok().body(this.cs.updateClient(client));
	}
	
	
}
