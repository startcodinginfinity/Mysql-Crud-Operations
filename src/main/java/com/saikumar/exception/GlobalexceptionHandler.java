package com.saikumar.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalexceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> userNotFoundException(UserNotFoundException ex){
		
		Map<String,Object> map = new LinkedHashMap<>();
		
		List<String> list = new LinkedList<>();
		
		list.add(ex.getLocalizedMessage());
		
		map.put("statusCode",HttpStatus.NOT_FOUND.value());
		map.put("message", list);
		map.put("timeStamp", LocalDateTime.now());
		
		return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		
	}


}
