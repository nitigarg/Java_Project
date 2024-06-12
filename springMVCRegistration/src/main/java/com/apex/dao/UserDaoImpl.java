package com.apex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.apex.beans.User;
import com.apex.utility.ValidationException;


public class UserDaoImpl implements UserDao{
	private static Connection getConnection() {
		Connection dbConn = null;
		try {
			// step1:
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step2
			String url = "jdbc:mysql://localhost:3306/training";
			// step3
			dbConn = DriverManager.getConnection(url, "root", "root@123");
		} catch (SQLException sql) {
			sql.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return dbConn;
	}

	@Override
	public int add(User user) throws SQLException {
		Connection connection = null;
		String errors = "";
		int resultId = 0;
		PreparedStatement pStatement = null;

		try {
			connection = getConnection();

			pStatement = connection.prepareStatement("insert into training.register values(?,?,?,?)");

			pStatement.setString(1, user.getFirstName());
			pStatement.setString(2, user.getLastName());
			pStatement.setString(3, user.getUserName());
			pStatement.setString(4, user.getPassword());
			System.out.println("Prepared Statement" + pStatement.toString());
			resultId = pStatement.executeUpdate();
			if (resultId != 1) {
				throw new Exception("Error in Registering User");
			}
		} catch (ValidationException validationException) {
			errors = validationException.getErrorMessage();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (pStatement != null) {
				pStatement.close();
				connection.close();
				System.out.println("Connections are closed");
			}
		}
		return resultId;
	}

	@SuppressWarnings("finally")
	@Override
	public String view(User user) throws ValidationException, SQLException {
		Connection connection = getConnection();
		String firstName = "";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			pStatement = connection.prepareStatement("select * from training.register where userName=? and password=?");
			pStatement.setString(1, user.getUserName());
			pStatement.setString(2, user.getPassword());
			resultSet = pStatement.executeQuery();
			System.out.println("ResultSet::" + resultSet);
			if (resultSet.next()) {
				firstName = resultSet.getString("firstName");
			} else {
				new ValidationException("Username and password does not exists");

			}

		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (pStatement != null) {
				pStatement.close();
				connection.close();

			}
			return firstName;

		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean checkUser(User user) throws ValidationException, SQLException {
		Connection connection = getConnection();
		boolean alreadyRegistered = false;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			pStatement = connection.prepareStatement("select * from training.register where userName=?");
			pStatement.setString(1, user.getUserName());
			resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				alreadyRegistered = true;
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (pStatement != null) {
				pStatement.close();
				connection.close();
			}
			return alreadyRegistered;

		}
	}
}
