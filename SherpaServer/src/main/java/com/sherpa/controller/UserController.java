package com.sherpa.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sherpa.dto.EventDto;
import com.sherpa.dto.UserDto;
import com.sherpa.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	/*
	 * TODO!
	 * 
	 * Refactor:
	 * 
	 * Kontrolera, Servisa i DAO-a
	 * 
	 * U DTO i Modelu doraditi toModel i toDTO
	 * 
	 * 
	 * Boot servera loada MySQL driver nekoliko puta ? neki SSL warn?
	 * 
	 * 
	 * Implementirati do kraja i Testirat Generic DAO na Admin Klasi
	 * 
	 * 
	 * Drugi Logger
	 * 
	 * 
	 * Ovo isto izmozgat:
	 * 
	 * U kontroleru se barata samo sa view objektima (DTO). Oni se salju u
	 * service di se pretvore u model / entity, prije nego ih posaljes u DAO (i
	 * obrnuto ako idu prema servisu)
	 * 
	 * Controller (DTO) -> Service (DTO -> Entity) -> DAO (Entity)
	 * 
	 * tj.
	 * 
	 * DAO (Entity) -> Service (Entity -> DTO) -> Controller (DTO)
	 * 
	 * E sad pitanje je da li je bolje drzati reference u Service-u kao DTO ili
	 * kao Model? Ako je DTO onda cemo morat rucno zvat querye koji su van
	 * transakcije, a ako su ostali kao Model s nested Proxy objektima, onda bi
	 * se iduci query trebao izvrsiti u istoj transakciji (zato
	 * ima @Transactional na klasi service)
	 * 
	 * 
	 * Vecina provjera se obavlja u servisu (npr. is null i ta sranja). DAO bi
	 * onda trebao imat sto vise metoda koje obavljaju sta god treba u sto
	 * manjem broju querya, zato je ovo gore "bitno"
	 * 
	 */

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> getUser(@PathVariable("id") long userId) {
		System.out.println("Fetching User with id " + userId);

		UserDto user = userService.findById(userId);

		if (user == null) {
			System.out.println("User with id " + userId + " not found");
			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> loginUserPost(@RequestBody UserDto userBody) {
		System.out.println(
				"Fetching User with Email: " + userBody.getEmail() + " and Password: " + userBody.getPassword());

		UserDto userDto = userService.loginUser(userBody.getEmail(), userBody.getPassword());

		if (userDto == null) {
			System.out.println("User with Email: " + userBody.getEmail() + " and Password: " + userBody.getPassword()
					+ " not found");
			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{email}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> loginUser(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		System.out.println("Fetching User with Email: " + email + " and Password: " + password);
		UserDto userDto = userService.loginUser(email, password);

		if (userDto == null) {
			System.out.println("User with Email: " + email + " and Password: " + password + " not found");
			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/events/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<EventDto>> getSherpaEvents(@PathVariable("id") long userId) {
		System.out.println("Fetching User events with user id " + userId);
		Set<EventDto> events = userService.getUserEvents(userId);
		if (events == null) {
			System.out.println("Events with user id " + userId + " not found");
			return new ResponseEntity<Set<EventDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Set<EventDto>>(events, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/region/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<UserDto>> getUsersByRegion(@PathVariable("name") String region) {

		System.out.println("Fetching Users in region: " + region);
		Set<UserDto> users = userService.getUsersByRegion(region);
		if (users == null) {
			System.out.println("Fetching Users in region " + region + " not found");
			return new ResponseEntity<Set<UserDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Set<UserDto>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/sherpas/region/{region}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<UserDto>> getSherpasByRegion(@PathVariable("region") String region) {

		System.out.println("Fetching Sherpas in region: " + region);
		Set<UserDto> sherpas = userService.getSherpasByRegion(region);
		if (sherpas == null) {
			System.out.println("Failed to fetch all sherpas in region: " + region);
			return new ResponseEntity<Set<UserDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Set<UserDto>>(sherpas, HttpStatus.OK);
	}

	@RequestMapping(value = "/sherpas/rating/{region}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<UserDto>> getSherpasByRating(@PathVariable("region") String region) {

		System.out.println("Fetching Sherpas by rating in region: " + region);

		Set<UserDto> sherpas = userService.getSherpasByRating(region);

		if (sherpas == null) {
			System.out.println("Failed to fetch all sherpas by rating in region: " + region);
			return new ResponseEntity<Set<UserDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Set<UserDto>>(sherpas, HttpStatus.OK);
	}

}
