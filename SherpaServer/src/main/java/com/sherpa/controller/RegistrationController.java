package com.sherpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sherpa.dto.UserDto;
import com.sherpa.dto.composite.UserLocationDto;
import com.sherpa.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;

	private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

	private UserDto userDto;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> registerUser(@RequestBody UserLocationDto request) {
		log.debug("Registering User with Email: '{}' and Password: '{}'", request.getUserDto().getEmail(),
				request.getUserDto().getPassword());

		/*
		 * TODO!
		 * 
		 * Napisat registration metodu koja prima composite userlocation i
		 * sprema novi record + provjera dal user s istim emailom vec postoji,
		 * bla bla
		 */

		if (userDto == null) {
			log.debug("User with Email: '{}' and Password: '{}' Not Found!", request.getUserDto().getEmail(),
					request.getUserDto().getPassword());
			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);

	}

}
