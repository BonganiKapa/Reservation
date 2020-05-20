package flight.reservation.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flight.reservation.springboot.model.PersonalDetails;

@RestController
@CrossOrigin
public class LoginController {
	
	
	@RequestMapping("/login")
	public boolean login(@RequestBody PersonalDetails client) {
		return client.getEmail().equals("email") && client.getPassword().equals("password");
	}
}
