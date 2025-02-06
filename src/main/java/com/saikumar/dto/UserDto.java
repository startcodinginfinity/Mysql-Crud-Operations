package com.saikumar.dto;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
	
	private String name;
	
	private String address;
	
	private Long salary;
	
	private Integer age;
	
	private String mobileNo;
	
	public String[] notNullColumns() {
		
		List<Object> list = new LinkedList<>();
		
		if(name == null) {
			
			list.add("name");
		}
		
		if(address == null) {
			
			list.add("address");
		}
		
		if(salary ==  null) {
			
			list.add("salary");
		}
		
		if(age ==  null) {
			
			list.add("age");
		}
		
		if(mobileNo == null) {
			
			list.add("mobileNo");
		}
		
		return list.toArray(new String[0]);
		
	}

}
