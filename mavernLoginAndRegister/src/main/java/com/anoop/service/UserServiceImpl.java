package com.anoop.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.anoop.DAO.UserDao;
import com.anoop.model.Login;
import com.anoop.model.User;

public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserDao userDao;
	
	public void register(User user)
	{
		userDao.register(user);
		
	}
		public User validateUser(Login login)
		{
			return userDao.validateUser(login);
		}
		
		
	
}
