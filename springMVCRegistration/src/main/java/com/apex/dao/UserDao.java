package com.apex.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.apex.beans.User;
import com.apex.utility.ValidationException;

@Repository
public interface UserDao {
	public int add(User user) throws SQLException;

	public String view(User user)throws ValidationException,SQLException;

	public boolean checkUser(User user)throws ValidationException,SQLException;

}
