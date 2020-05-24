package com.example.demo.web.controller;

import com.example.demo.core.jpa.domain.User;
import com.example.demo.web.service.UserService;
import com.example.demo.web.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegisterController {
	@Autowired
	private UserService userService;


	@Autowired
	private UserValidator userValidator;

	@GetMapping(value = "/register")
	public String registerPage(Model model) {
		model.addAttribute("userForm", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "register";
		}
		userForm.setRole("USER");
		userService.save(userForm);
		return "redirect:/index";
	}
}
