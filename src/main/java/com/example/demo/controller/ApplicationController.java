package com.example.demo.controller;

import com.example.demo.core.jpa.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ApplicationController {
	private CourseController courseController;

	@Autowired
	public ApplicationController(CourseController courseController) {
		this.courseController = courseController;
	}

	@GetMapping(value = "/index")
	public String showIndex(Model theModel) {
		return "index";
	}

	@GetMapping(value = "/login")
	public String loginPage(Model theModel) {
		return "login";
	}

	@GetMapping(value = "/register")
	public String registerPage(Model theModel) {
		return "register";
	}


	@GetMapping(value = "/panel")
	public String showPanel(Model theModel) {

		List<Course> courseList = courseController.findAll();
		theModel.addAttribute("courseList", courseList);
		return "panel";
	}

	@GetMapping(value = "/showForm")
	public String showFormForAdd(Model theModel) {
		Course course = new Course();
		theModel.addAttribute("course", course);
		return "course-form";
	}


}