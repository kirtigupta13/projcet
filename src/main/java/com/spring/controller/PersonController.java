package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Person;
import com.spring.model.User;
import com.spring.service.PersonService;
/**
 * https://github.com/in28minutes/SpringMvcStepByStep/blob/master/src/main/java/com/in28minutes/login/WelcomeController.java
 * @author kirti gupta
 *
 */

@Controller
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@RequestMapping(value="/listUsers",method=RequestMethod.GET)
	public ModelAndView registerSucess()
	{
		ModelAndView modelAndView = new ModelAndView("userList");
		List<User> list = service.getUserList();
		modelAndView.addObject("userList", list);
		return modelAndView;
	}
	
	
	@RequestMapping("/person")
	public String person(Model model)
	{
		Person p = new Person();
		p.setId(1);
		p.setName("name");
		p.setAddress("address");
		model.addAttribute("person", p);
		return "personview";
	}

	
	@ResponseBody
	@RequestMapping("/")
    public String entry()
    {
		return "hello kirti";
    }
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage()
	{
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password,
			ModelMap model) 
	{
		if(!service.validateUser(name, password))
		{
			model.put("name", name);
			model.put("password", password);
			return "login";
		}
		else
		{
			return "welcome";
		}
	}
}
