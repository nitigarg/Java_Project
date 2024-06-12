package com.apex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apex.beans.User;
import com.apex.service.AddUser;
import com.apex.service.ViewUser;
import com.apex.utility.ValidationException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class RegistrationController {

	@Autowired
	AddUser addUser;

	@Autowired
	ViewUser viewUser;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String registerForm() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) throws ValidationException, Exception {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		boolean alreadyRegistered = true;
		int resultId;
		try {
			// check if userName already Registered
			alreadyRegistered = viewUser.check(user);
			if (alreadyRegistered == false) {
				resultId = addUser.add(user);
				if (resultId == 1) {
					modelAndView.setViewName("success");
					modelAndView.addObject("user", user);
				} else {
					session.setAttribute("errors", ValidationException.getErrorMessage());
					modelAndView.setViewName("register");
				}
			} else {

				session.setAttribute("errors", "UserName already exists");
				modelAndView.setViewName("register");
			}
		} catch (Exception e) {

			e.getMessage();

		}

		return modelAndView;
	}
}
