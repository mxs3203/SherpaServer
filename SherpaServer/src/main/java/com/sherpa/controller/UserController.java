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
import com.sherpa.dto.composite.UserLocationDto;
import com.sherpa.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	/*
	 * TODO!
	 * 
	 * Refactor:
	 * 
	 * REFACTOR EVENT KONTROLERA!
	 * 
	 * Kontrolera, Servisa i DAO-a
	 * 
	 * U DTO i Modelu doraditi toModel i toDTO
	 * 
	 * 
	 * Na DEV kompove stavit konfiguraciju iz deployment-a
	 * 
	 * 
	 * Delete Rjesen?
	 * 
	 * Implementirati do kraja i Testirat Generic DAO na Admin Klasi -> GENERIC
	 * DAO -> trazi Entity / Model class type za Delete -> drugim rijecima
	 * delete se mora izvrsit u servisu (a DAO onda mora primiti Entity klasu?
	 * za delete metodu?) ILI
	 * entityManager.remove(entityManager.getReference(**clazz, **id));?
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
	 * Vecina provjera se obavlja u servisu (npr. is null i ta sranja). DAO bi
	 * onda trebao imat sto vise metoda koje obavljaju sta god treba u sto
	 * manjem broju querya
	 * 
	 * 
	 * 
	 * ResponseEntity promjenit u odgovarajuci, ex: result == null ->
	 * httpStatus.no_result
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

		UserDto userDto = userService.findById(userId);

		if (userDto == null) {
			log.debug("User with ID: {} Not Found!", userId);
			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);

	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userBody) {
		log.debug("Fetching User with Email: '{}' and Password: '{}'", userBody.getEmail(), userBody.getPassword());

		UserDto userDto = userService.loginUser(userBody);

		if (userDto == null) {
			log.debug("User with Email: '{}' and Password: '{}' Not Found!", userBody.getEmail(),
					userBody.getPassword());
			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);

	}

	@RequestMapping(value = "/sherpa/events/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<EventDto>> getSherpaEvents(@PathVariable("id") long userId) {
		log.debug("Fetching Events For User With ID: {}", userId);

		Set<EventDto> events = userService.getSherpaEvents(userId);

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
		log.debug("Fetching Sherpas in Region: '{}'", region);

		Set<UserDto> sherpas = userService.getSherpasByRegion(region);

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

	@RequestMapping(value = "/user/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> registerUser(@RequestBody UserLocationDto requestBody) {
		log.debug("Registering User with Email: '{}' and Password: '{}'", requestBody.getUserDto().getEmail(),
				requestBody.getUserDto().getPassword());

		/*
		 * TODO!
		 * 
		 * Napisat registration metodu koja prima composite userlocation i
		 * sprema novi record + provjera dal user s istim emailom vec postoji,
		 * bla bla
		 */

		UserDto userDto = userService.registerUser(requestBody);

		if (userDto == null) {
			log.debug("User with Email: '{}' and Password: '{}' Not Found!", requestBody.getUserDto().getEmail(),
					requestBody.getUserDto().getPassword());
			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);

	}

}
