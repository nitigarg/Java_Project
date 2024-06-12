package com.apex.springBoot.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apex.springBoot.beans.User;
import com.apex.springBoot.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;

	public User adduser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userDAO.addUser(user)>0?user:null;
	}

	public int updateUser(User user,int id) throws Exception {
		
		return userDAO.updateUser(user,id);
	}

	public int deleteUser(int id) throws SQLException {
		// TODO Auto-generated method stub
		return userDAO.deleteUser(id);
	}

	public List<User> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		return userDAO.getAllUsers();
	}

}
