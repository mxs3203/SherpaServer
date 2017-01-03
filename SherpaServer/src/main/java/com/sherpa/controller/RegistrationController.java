package com.sherpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sherpa.dto.RegisterDto;
import com.sherpa.dto.UserDto;
import com.sherpa.model.Location;
import com.sherpa.model.User;
import com.sherpa.service.LocationService;
import com.sherpa.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private LocationService locationService;

	private User user;
	private UserDto userDto;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> registerUserPost(@RequestBody RegisterDto registerBody) {
		System.out.println("Fetching User with Email: " + registerBody.getUserDto().getEmail() + " and Password: "
				+ registerBody.getUserDto().getPassword());

		Location loc = registerBody.getLocationDto().toModel();

		locationService.addLocation(loc);

		userDto = registerBody.getUserDto();
		user = userDto.toModel();
		user.setLocation(loc);
		userService.addUser(user);

		userDto = userService.findById(user.getUserId());

		if (userDto == null) {
			System.out.println("User with Email: " + registerBody.getUserDto().getEmail() + " and Password: "
					+ registerBody.getUserDto().getPassword() + " not found");
			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
	}
}
