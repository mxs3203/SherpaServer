package com.sherpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sherpa.dto.AdminDto;
import com.sherpa.service.AdminService;

@Controller
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;

	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}

	@RequestMapping(value = "/admin/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AdminDto> getAdmin(@PathVariable("id") long userId) {
		log.debug("Fetching User with ID: {}", userId);

		AdminDto adminDto = adminService.findById(userId);

		if (adminDto == null) {
			log.debug("User with ID '{}' Not Found!", userId);
			return new ResponseEntity<AdminDto>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<AdminDto>(adminDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AdminDto> loginAdmin(@RequestBody AdminDto adminBody) {
		log.debug("Fetching Admin with Username: '{}' and Password: '{}'", adminBody.getUsername(),
				adminBody.getPassword());

		AdminDto adminDto = adminService.loginAdmin(adminBody);

		if (adminDto == null) {
			log.debug("Admin with Username: '{}' and Password: '{}' Not Found!", adminBody.getUsername(),
					adminBody.getPassword());
			return new ResponseEntity<AdminDto>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<AdminDto>(adminDto, HttpStatus.OK);
	}

}
