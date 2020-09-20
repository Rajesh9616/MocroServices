package com.sharma.app.ws.mobileappws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.app.ws.mobileappws.ui.model.request.UpdateUserDetailsRequest;
import com.sharma.app.ws.mobileappws.ui.model.request.UserDetailsRequest;
import com.sharma.app.ws.mobileappws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")

public class UserController {

	// Adding dummy Map to store value
	Map<String, UserRest> users;

	@GetMapping
	// passing defaultValue for page and limit
	public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = true) int page,
			@RequestParam(value = "limit", defaultValue = "20") int limit,
			@RequestParam(value = "sort", defaultValue = "asc") String orderType) {
			
		
		return "get User was called get from page " + page + " till limit" + limit + " and order type " + orderType;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUsers(@PathVariable String userId) {
		if (users.containsKey(userId))		
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
		else
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
	}

	// Applying basic validation
	// Adding Users to the Map
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequest userDetails) {
		UserRest ur = new UserRest();
		ur.setFirstName(userDetails.getFirstName());
		ur.setLastName(userDetails.getLastName());
		ur.setEmail(userDetails.getEmail());
		
		String userId = UUID.randomUUID().toString();
		ur.setUserId(userId);
		if(users == null) users = new HashMap<>();
		users.put(userId, ur);
		

		return new ResponseEntity<UserRest>(ur, HttpStatus.CREATED);
	}

	// Required 2 Information 
	// 1. UserId and 2. UserDetails
	@PutMapping(path = "/{userId}",
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
					MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId,
						@Valid @RequestBody UpdateUserDetailsRequest userDetails
			) {
		
		if (users.containsKey(userId)) {
			UserRest ur = new UserRest();
			ur.setFirstName(userDetails.getFirstName());
			ur.setLastName(userDetails.getLastName());
			users.put(userId, ur);
			return new ResponseEntity<UserRest>(ur,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<UserRest>(HttpStatus.NOT_MODIFIED);
		}	
		
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<UserRest> deleteUser(@PathVariable String userId) {
		
		// Testing Exception Handling in Centralized way 
		// Un-comment line 97 and 98
			//String s;
			//int a = s.length();
		
		if (users.containsKey(userId)) {
			users.remove(userId);
			return new ResponseEntity<UserRest>(users.remove(userId),HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<UserRest>(HttpStatus.NOT_FOUND);
		}
		
	}

}
