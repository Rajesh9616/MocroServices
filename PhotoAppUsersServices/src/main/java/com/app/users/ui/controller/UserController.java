package com.app.users.ui.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.users.entity.UserEntity;
import com.app.users.service.UserService;
import com.app.users.ui.model.CreateUserRequestModel;
import com.app.users.ui.shared.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	Environment env;
	
	@GetMapping("/status/check")
	//@RequestMapping(method = RequestMethod.GET)
	public String checkStatus() {
		System.out.println(env.getProperty("spring.datasource.username"));
		return "User Controller Status working";
	}
	
	
	@PostMapping(consumes =  {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
				produces =  {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<CreateUserRequestModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		UserDto createUser = userService.createUser(userDto);
		CreateUserRequestModel returnValue = modelMapper.map(createUser, CreateUserRequestModel.class);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}

}
