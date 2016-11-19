package com.sherpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sherpa.dto.Admin;
import com.sherpa.service.AdminService;

@Controller
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	private Admin admin;
	
	@RequestMapping(method = RequestMethod.GET)
    public String getIndex() {
        return "admin";
    }

	@RequestMapping(value = "/admin/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Admin> getUser(@PathVariable("id") Long userId) {
        System.out.println("Fetching User with id " + userId);
        admin = adminService.findById(userId);
        if (admin == null) {
            System.out.println("User with id " + userId + " not found");
            return new ResponseEntity<Admin>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Admin>(admin, HttpStatus.OK);
    }

}