package com.app.users.serviceImpl;


import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.users.entity.UserEntity;
import com.app.users.entity.data.UserRepository;
import com.app.users.service.UserService;

import com.app.users.ui.shared.UserDto;

@Service
public class UserServiceImpl implements UserService{	
	
	public Environment env;
	
	public UserRepository userRepository;
	
	public BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		//this.env = env;
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	

	@Override
	public UserDto createUser(UserDto userDetails) {
		
		// Generating and assigning Random UUID
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncriptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		
		
		
		
		//userEntity.setEncriptedPassword("test");
		// Save Object to the DB
		userRepository.save(userEntity);
		
		// Mapping user details to the UserDto object
		UserDto returnValue = modelMapper.map(userEntity, UserDto.class);
		
		return returnValue;
	}


}
