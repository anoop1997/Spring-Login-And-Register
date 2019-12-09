package com.anoop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anoop.model.User;
import com.anoop.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
UserService userService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	
	public ModelAndView home()
	{
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
	
@RequestMapping(value="/register",method=RequestMethod.GET)
	
	public ModelAndView showRegister()
	{
		ModelAndView mv=new ModelAndView("register");
		return mv;
	}
	
	
	@RequestMapping(value="/registerprocess",method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, User user) {	
		userService.register(user);
		System.out.println("hi");
		return new ModelAndView("welcome","firstname",user.getFname());
	}

}
