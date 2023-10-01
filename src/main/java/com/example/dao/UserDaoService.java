package com.example.dao;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.example.entity.User;

@Component
public class UserDaoService {
	
	private static List<User> userList = new ArrayList<>();
	
	static {
		userList.add(new User(1,"Satyam",LocalDate.now().minusYears(10)));
		userList.add(new User(2,"Shivam",LocalDate.now().minusYears(15)));
		userList.add(new User(3,"Shundram",LocalDate.now().minusYears(20)));
	}
	
	public List<User> getAllUser(){
		return userList;
	}
	
	public User addUser(User user) {
		userList.add(user);
		return user;
	}

}
