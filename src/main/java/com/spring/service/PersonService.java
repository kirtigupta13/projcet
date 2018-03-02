package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.UserDao;
import com.spring.model.User;

@Service
public class PersonService {
	
	@Autowired
	private UserDao dao;
	
	public List<User> getUserList()
	{
		return dao.getUserList();
	}
	
	public void createUser(User user)
	{
		 dao.addUser(user);
		
	}
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("Kirti") && password.equals("gupta");
	}

}
