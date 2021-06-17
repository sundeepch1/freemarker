package com.skc.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.skc.model.User;

@Controller
public class AppplicationController {
	
	@GetMapping("/greeting/{input}")
	public String greeting(@PathVariable String input, Model model) {
		String welcomeMessage = "Hi" + input + " welcome to java.";
		model.addAttribute("message", welcomeMessage);
		return "welcome";
	}
	
	@GetMapping("/getUsers")
	public String getUser(Model model) {
		List<User> users = Stream.of(new User(1, "Lucky", "USA"), new User(1, "Pitter", "England"), new User(1, "Balmer", "Sydney")).collect(Collectors.toList());
	
		model.addAttribute("users", users);
		return "userList";
	}
}
