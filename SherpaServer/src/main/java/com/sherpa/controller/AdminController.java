package com.sherpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sherpa.dto.AdminDto;
import com.sherpa.service.AdminService;

@Controller
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}

	@RequestMapping(value = "/admin/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminDto> getUser(@PathVariable("id") long userId) {

		System.out.println("Fetching User with id " + userId);

		AdminDto adminDto = adminService.findById(userId);

		if (adminDto == null) {
			System.out.println("User with id " + userId + " not found");
			return new ResponseEntity<AdminDto>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<AdminDto>(adminDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/{username}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminDto> loginAdmin(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		System.out.println("Fetching Admin with username: " + username + " and Password: " + password);

		AdminDto adminDto = new AdminDto();
		adminDto.setUsername(username);
		adminDto.setPassword(password);

		adminDto = adminService.verifyAdmin(adminDto);

		if (adminDto == null) {
			System.out.println("Admin with username: " + username + " and Password: " + password + " not found");
			return new ResponseEntity<AdminDto>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AdminDto>(adminDto, HttpStatus.OK);
	}

}