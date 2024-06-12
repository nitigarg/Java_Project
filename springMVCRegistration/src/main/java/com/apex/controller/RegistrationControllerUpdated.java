package com.apex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apex.beans.User;
import com.apex.service.AddUser;
import com.apex.service.ViewUser;
import com.apex.utility.ValidationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class RegistrationControllerUpdated {

	@Autowired
	AddUser addUser;

	@Autowired
	ViewUser viewUser;

	@RequestMapping(value = "/formUpdated", method = RequestMethod.GET)
	public String registerForm() {
		return "registerupdated";
	}

	@RequestMapping(value = "/registerUpdated", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute("user") User user,BindingResult result) throws ValidationException, Exception {
		ModelAndView modelAndView = new ModelAndView();
		boolean alreadyRegistered = true;
		int resultId;
	
			// check if userName already Registered
			alreadyRegistered = viewUser.check(user);
			if (alreadyRegistered == false) {
				resultId = addUser.add(user);
				if (resultId == 1) {
					modelAndView.setViewName("success");
					modelAndView.addObject("user", user);
				} else {
					//result.addAllErrors(result);
					//modelAndView.addObject("errors",result);
					modelAndView.setViewName("registerupdated");
				}
				if(result.hasErrors()) {
					modelAndView.addObject("errors",result);
					modelAndView.setViewName("registerupdated");
				}
			}
		return modelAndView;
	}
}
