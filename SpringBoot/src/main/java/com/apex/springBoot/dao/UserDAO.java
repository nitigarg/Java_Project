package com.apex.springBoot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.apex.springBoot.beans.User;

import jakarta.annotation.PostConstruct;

@Repository
public class UserDAO {

	private Connection connection = null;
	PreparedStatement pStatement = null;

	@Value("${dbusername}")
	private String dbusername;

	@Value("${dbpassword}")
	private String dbpassword;

	@PostConstruct
	private void getConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			String url="jdbc:mysql://localhost:3306/training?useSSL=false";
			connection = DriverManager.getConnection(url,dbusername,dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addUser(User user) throws SQLException {
		int executeStatus = 0;
		String sqlQuery="insert into training.newuser (name,age,address)values(?,?,?)";
		pStatement = connection.prepareStatement(sqlQuery);
		pStatement.setString(1, user.getName());
		pStatement.setInt(2, user.getAge());
		pStatement.setString(3, user.getAddress());
		System.out.println("Prepared Statement" + pStatement.toString());
		executeStatus = pStatement.executeUpdate();

		return executeStatus;
	}

	public int updateUser(User user,int id) throws SQLException, ClassNotFoundException {
		int executeStatus = 0;
		UserDAO userdao=new UserDAO();
		boolean alreadyRegistered=userdao.authenticate(id);
		
		System.out.println("updateUser()UserDAO "+alreadyRegistered);
		if(alreadyRegistered==false) {
			return 0;
		}
		else {
		String sqlQuery="update training.newuser set name=?,age=?,address=? where id=?";
		pStatement = connection.prepareStatement(sqlQuery);
		pStatement.setInt(4, id);
		pStatement.setString(1, user.getName());
		pStatement.setInt(2, user.getAge());
		pStatement.setString(3, user.getAddress());
		System.out.println("Update Statement" + pStatement.toString());
		executeStatus = pStatement.executeUpdate();

		return executeStatus;
	}
	}
	
	
	public boolean authenticate(int id) throws SQLException, ClassNotFoundException {
		boolean alreadyRegistered = false;
		ResultSet resultSet = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			String url="jdbc:mysql://localhost:3306/training?useSSL=false";
			connection = DriverManager.getConnection(url,"root","root@123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			pStatement = connection.prepareStatement("select * from training.newuser where id=?");
			pStatement.setInt(1,id);
			System.out.println("Authenticate Statement" + pStatement.toString());
			resultSet = pStatement.executeQuery();
			
			if (resultSet.next()) {
				alreadyRegistered = true;
			}
			return alreadyRegistered;

		}

	public int deleteUser(int id) throws SQLException {
		int executeStatus = 0;
		String sqlQuery="delete from training.newuser where id=?";
		pStatement = connection.prepareStatement(sqlQuery);
		pStatement.setInt(1,id);
		System.out.println("Prepared Statement" + pStatement.toString());
		executeStatus = pStatement.executeUpdate();

		return executeStatus;
		
	}

	public List<User> getAllUsers() throws SQLException {
		ResultSet rs=null;
		List<User>list=new ArrayList<>();
		pStatement = connection.prepareStatement("select * from training.newuser");
		rs = pStatement.executeQuery();
		
		while (rs.next()) {
			User user=new User();
				user.setId(rs.getInt("id"));	
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setAddress(rs.getString("address"));
				list.add(user);
		}
		return list;
	}
	

}
