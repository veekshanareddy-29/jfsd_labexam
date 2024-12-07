package klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import klu.model.User;
import klu.model.UserManager;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserManager UM;
	
	@PostMapping("/save")
	public String save(@RequestBody User U)
	{
		return UM.saveUser(U);
	}
	
	@GetMapping("/login/{uname}/{pwd}")
	public String login(@PathVariable("uname") String uname,@PathVariable("pwd") String pwd)
	{
		return UM.loginUser(uname, pwd);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User U)
	{
		return UM.loginUser(U.getUsername(), U.getPassword());
	}
}
