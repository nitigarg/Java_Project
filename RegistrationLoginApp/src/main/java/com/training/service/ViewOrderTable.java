package com.training.service;

import java.util.List;

import com.training.DAO.UserDAO;
import com.training.DAO.UserDAOImpl;
import com.training.entity.OrderDetails;

public class ViewOrderTable {

	public List<OrderDetails> viewOrderDetails() {
		List<OrderDetails> list;
		UserDAO userDAO = new UserDAOImpl();
		list = userDAO.getOrderDetails();
		return list;

	}
}
