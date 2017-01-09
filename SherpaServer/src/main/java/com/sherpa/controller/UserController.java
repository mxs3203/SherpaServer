package com.sherpa.controller;

import java.util.Set;

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

import com.sherpa.dto.EventDto;
import com.sherpa.dto.UserDto;
import com.sherpa.model.User;
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
	 * Implementirati do kraja i Testirat Generic DAO na Admin Klasi -> GENERIC
	 * DAO -> trazi Entity / Model class type za Delete -> drugim rijecima
	 * delete se mora izvrsit u servisu (a DAO onda mora primiti Entity klasu?
	 * za delete metodu?) ILI
	 * entityManager.remove(entityManager.getReference(**clazz, **id));?
	 * 
	 * 
	 * System.out-ove pocistit, ostavit samo najbitnije i prebacit ih u Logger
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
	 * 
	 * 
	 * 
	 * Datasource JNDI?
	 * 
	 * Boot servera MySQL driver SSL warning? -> rjeseno sa use SSL=false?
	 * 
	 */

	@Autowired
	private UserService userService;

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> getUser(@PathVariable("id") long userId) {
		log.debug("Fetching User with ID: {}", userId);

		User user = new User();
		user.setUserId(userId);

		UserDto userDto = userService.findById(user);

		if (userDto == null) {
			log.debug("User with ID: {} Not Found!", userId);
			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);

	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userBody) {
		log.debug("Fetching User with Email: '{}' and Password: '{}'", userBody.getEmail(), userBody.getPassword());

		User user = new User();
		user.setEmail(userBody.getEmail());
		user.setPassword(userBody.getPassword());

		UserDto userDto = userService.loginUser(user);

		if (userDto == null) {
			log.debug("User with Email: '{}' and Password: '{}' Not Found!", userBody.getEmail(),
					userBody.getPassword());
			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);

	}

	@RequestMapping(value = "/user/events/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<EventDto>> getSherpaEvents(@PathVariable("id") long userId) {
		log.debug("Fetching Events For User With ID: {}", userId);

		User user = new User();
		user.setUserId(userId);

		Set<EventDto> events = userService.getUserEvents(user);

		if (events == null) {
			log.debug("Events For User With ID: {} Not Found!", userId);
			return new ResponseEntity<Set<EventDto>>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Set<EventDto>>(events, HttpStatus.OK);

	}

	@RequestMapping(value = "/users/region/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<UserDto>> getUsersByRegion(@PathVariable("name") String region) {
		log.debug("Fetching Users in Region: '{}'", region);

		Set<UserDto> users = userService.getUsersByRegion(region);

		if (users == null) {
			log.debug("Users in Region: '{}' Not Found!", region);
			return new ResponseEntity<Set<UserDto>>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Set<UserDto>>(users, HttpStatus.OK);

	}

	@RequestMapping(value = "/sherpas/region/{region}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<UserDto>> getSherpasByRegion(@PathVariable("region") String region) {

		/* TODO! */
		log.debug("Fetching Sherpas in Region: '{}'", region);

		Set<UserDto> sherpas = null;/*
									 * userService.getSherpasByRegion(region);
									 */

		if (sherpas == null) {
			log.debug("Failed to Fetch Sherpas in Region: '{}'", region);
			return new ResponseEntity<Set<UserDto>>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Set<UserDto>>(sherpas, HttpStatus.OK);

	}

	@RequestMapping(value = "/sherpas/rating/{region}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<UserDto>> getSherpasByRating(@PathVariable("region") String region) {
		log.debug("Fetching Sherpas by Rating in Region: '{}'", region);

		Set<UserDto> sherpas = userService.getSherpasByRatingInRegion(region);

		if (sherpas == null) {
			log.debug("Failed to Fetch Sherpas by Rating in Region: '{}'", region);
			return new ResponseEntity<Set<UserDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Set<UserDto>>(sherpas, HttpStatus.OK);

	}

}
