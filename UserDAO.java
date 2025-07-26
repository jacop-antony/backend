package com.tap.dao;

import java.util.List;
import com.tap.model.User;

public interface UserDAO {

	public List<User> getAllUsers();

	public void addUser(User user);

	public void updateUser(User user);

	void deleteUser(int id);
	
	User getUser(int id);

}
