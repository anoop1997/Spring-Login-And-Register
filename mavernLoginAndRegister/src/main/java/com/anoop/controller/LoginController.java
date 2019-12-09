package com.anoop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anoop.model.Login;
import com.anoop.model.User;
import com.anoop.service.UserService;
@Controller
public class LoginController {
	
	@Autowired
	 public UserService userService;
	@RequestMapping(value="/login", method = RequestMethod.GET)
		public  ModelAndView showHome() {
		ModelAndView mav=new ModelAndView("login");
		return mav;
		}
	@RequestMapping(value="/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request,HttpServletResponse response,Login loginn) {
		ModelAndView mav=null;
		User user=userService.validateUser(loginn);
		if(null !=user) {
			mav=new ModelAndView("register");
			mav.addObject("firstname", user.getFname());
		}
		else {
			mav=new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
		}
	

}
