package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.User;


@Controller
public class RegistoryController {

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String registerPage()
	{
		return "registeffrefr";
	}
	
	@RequestMapping(value="/registerSuccess1",method=RequestMethod.POST)
	public ModelAndView registerSuccess(@RequestParam("name") String userName,@RequestParam("country") String country,@RequestParam(required=false,name="email") String email,@RequestParam(name="age") int age)
	{
		User user = new User(userName, age, email, country);
		ModelAndView modelAndView = new ModelAndView("registerSuccess");
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}
}
