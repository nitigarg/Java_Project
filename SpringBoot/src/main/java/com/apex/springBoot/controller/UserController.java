package com.apex.springBoot.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apex.springBoot.beans.User;
import com.apex.springBoot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/message")
	public String getDemo() {
		return "Welcome to spring boot demo";

	}

	@GetMapping
	public List<User> getUser() throws SQLException {

		return userService.getAllUsers();
	}

	@PostMapping
	public User createUser(@RequestBody User user) throws SQLException {
		// System.out.println(user);

		return userService.adduser(user);
	}

	@PutMapping("/{id}")
	public String updateUser(@RequestBody User user, @PathVariable("id") int id) throws Exception {
		System.out.println("update user" + id);
		return userService.updateUser(user, id) > 0 ? "user updated" : "User does not exists";
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") int id) throws SQLException {

		return userService.deleteUser(id) > 0 ? "user deleted successfully" : "Cannot delete user";
	}
}
