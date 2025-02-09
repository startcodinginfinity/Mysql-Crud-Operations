package com.saikumar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saikumar.dto.UserDto;
import com.saikumar.entity.User;
import com.saikumar.exception.UserNotFoundException;
import com.saikumar.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void saveData(User user) {
		
		userRepository.save(user);
		
	}

	public List<User> getAllUserDetails() {
		
		return userRepository.findAll();
	}
	
	public User getUserById(int userId) {
		
		return userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User Not Found"));
		
	}

	public void updateUserDetails(Integer userId, UserDto user) {
		
     Optional<User>	optionalUser = userRepository.findById(userId);
     
     if(optionalUser.isPresent()) {
    	 
    	 BeanUtils.copyProperties(user, optionalUser.get(), user.notNullColumns());
    	 
    	 System.out.println(user);

    	 System.out.println(optionalUser);
    	 userRepository.save(optionalUser.get());
    	  
     }else {
    	 
    	 throw new UserNotFoundException("User with id "+userId+" is not found");
     }
		
	}

	public void removeRecord(int userId) {
		
		userRepository.deleteById(userId);
		
	}
	
	

}
