package com.appsdeveloperblog.app.ws.ui.controller;

import com.appsdeveloperblog.app.ws.exceptions.UserServiceException;
import com.appsdeveloperblog.app.ws.ui.model.response.ErrorMessages;
import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.dto.UserDto;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

import java.awt.*;

@RestController
@RequestMapping("users") //http://localhost:8080/
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	@GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public UserRest getUser(@PathVariable String id)
	{
		UserRest returnValue = new UserRest();

		UserDto userDto = userService.getUserById(id);


		BeanUtils.copyProperties(userDto, returnValue);

		return returnValue;
	}
	
	@PostMapping(
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception
	{
		UserRest returnValue = new UserRest(); //Define return object

		if (userDetails.getFirstName().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		UserDto userDto = new UserDto(); //Define transfer object
		BeanUtils.copyProperties(userDetails, userDto); //Mapping receive object to transfer object
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
	}
	
	@PutMapping
	public String updateUser()
	{
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser()
	{
		return "delete user was called";
	}
}
