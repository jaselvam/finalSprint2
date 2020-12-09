package com.sprint2.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint2.model.User;

public interface IUserController {
	public @ResponseBody String login(User user);
	public @ResponseBody User insertUser(@RequestBody User user);
	public @ResponseBody boolean deleteUser(@PathVariable("username") String userName);
	public @ResponseBody String logout(User user);
}
