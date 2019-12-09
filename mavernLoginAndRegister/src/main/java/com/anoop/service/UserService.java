package com.anoop.service;

import com.anoop.model.Login;
import com.anoop.model.User;

public interface UserService {

	
	void register(User user);
	User validateUser(Login login);
	
	
	
}
