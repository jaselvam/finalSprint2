package com.sprint2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint2.model.User;
import com.sprint2.service.UserService;






@Controller
@RequestMapping("/fms/m2")        //Maps a specific request path or pattern onto a controller
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired       // To establish relationship with user service
	private UserService userService;
	
	@GetMapping("/Login")       
	public @ResponseBody String login(User user)
	{
		logger.debug("login service initialised");     //prints the given message in log file whenever user tries to login.
		logger.info("login service initialised");
		return userService.login(user);
	}
	@PostMapping("/Login")         // @PostMapping is used to insert user records
	public @ResponseBody User insertUser(@RequestBody User user)
	{
		return userService.insertUser(user);
	}
	@DeleteMapping("/Login/{username}")          // @DeleteMapping is used to delete user records
	public @ResponseBody boolean deleteUser(@PathVariable("username") String userName)
	{
		return userService.deleteAdminbyName(userName);
		
	}
	@GetMapping("/Logout")
	public @ResponseBody String logout(User user)
	{
		logger.info("logout service initialised");    //prints the given message in log file whenever user tries to logout.
		return userService.logout(user);
	}
	
	
}

