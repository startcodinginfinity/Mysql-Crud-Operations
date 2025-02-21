package com.saikumar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saikumar.dto.UserDto;
import com.saikumar.entity.User;
import com.saikumar.service.UserService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	@Transactional
	public ResponseEntity<?> saveData(@RequestBody @Valid User user){
		
	    userService.saveData(user);
		
		return new ResponseEntity<>("Data saved into database",HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAll")
	@Transactional
	public ResponseEntity<List<User>> getAllUserDetails(){
		
	List<User> userDetailsObject =	userService.getAllUserDetails();
	
	return new ResponseEntity<>(userDetailsObject,HttpStatus.OK);
		
	}
	
	@GetMapping("/getBy/{userId}")
	@Transactional
	public ResponseEntity<User> getAllUserDetails(@PathVariable int userId){
		
	User userDetailsObject =	userService.getUserById(userId);
	
	return new ResponseEntity<>(userDetailsObject,HttpStatus.OK);
		
	}
	
	
	
	@PutMapping("/update/{userId}")
	@Transactional
	public ResponseEntity<?> updateUserDetails(@PathVariable Integer userId, @RequestBody UserDto user){
		
		userService.updateUserDetails(userId,user);
		
		return new ResponseEntity<>("The Details of user with userId "+userId+" has updated",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/remove/{userId}")
	public ResponseEntity<?> removeRecord(@PathVariable int userId){
		
		userService.removeRecord(userId);
		
		return new ResponseEntity<>("The user with userId "+userId+" has sucessfully deleted",HttpStatus.OK);
		
	}
	
	
	

}
