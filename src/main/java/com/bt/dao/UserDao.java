package com.bt.dao;

import java.util.List;

import com.bt.domain.*;

public interface UserDao {
	 public List<User> getUsers();
	    public User getUserById(int id);
	    public int saveUser(User u);
	    public void persistUser(User u);
	    public boolean updateUser(User u);
	    public User mergeUser(User u);
	    public User login(String username, String password);
}
