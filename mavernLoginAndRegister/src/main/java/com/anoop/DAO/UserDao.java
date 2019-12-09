package com.anoop.DAO;

import com.anoop.model.Login;
import com.anoop.model.User;

public interface UserDao {

	void register (User user);
	User validateUser(Login login);
}
