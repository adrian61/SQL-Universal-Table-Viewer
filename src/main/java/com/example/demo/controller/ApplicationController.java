package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/postgressApp")
public class ApplicationController {
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(Model theModel) {
		return "index";
	}
}