package com.training.DAO;

import java.sql.SQLException;
import java.util.List;

import com.training.entity.OrderDetails;
import com.training.entity.User;
import com.training.utility.ValidationException;

public interface UserDAO {

	public int add(User user) throws SQLException;

	public String view(User user) throws ValidationException, SQLException;
	public boolean checkUser(User user) throws ValidationException, SQLException;
	public  List<OrderDetails> getOrderDetails();

}
