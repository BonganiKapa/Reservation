package flight.reservation.springboot.controller;

import java.security.Principal;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping("/client")
	public Principal client(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization")
				.substring("Basic".length()).trim();
		return () -> new String(Base64.getDecoder()
				.decode(authToken)).split(":")[0];
	}
}


