package com.example.demo.web.controller;

import com.example.demo.core.jpa.dao.CourseDAO;
import com.example.demo.core.jpa.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ApplicationController {
	private CourseController courseController;
	@Autowired
	private CourseDAO courseDAO;

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

	@GetMapping(value = "/updateForm/{id}")
	public String showFormForUpdate(@PathVariable int id, Model theModel) {
		Course course = courseDAO.getCourse(id);
		theModel.addAttribute("course", course);
		return "course-form";
	}

	//TODO delete this and use rest in the future
	@PostMapping("/api/saveCourse")
	public String saveCourse(@ModelAttribute("course") Course course) {
		System.out.println(course.getDescription());
		courseDAO.saveCourse(course);
		return "redirect:/panel";
	}


	@GetMapping(value = "api/deleteCourse/{id}")
	public String handleDeleteUser(@PathVariable int id) {
		courseDAO.deleteCourse(id);
		return "redirect:/panel";
	}

	@GetMapping("/access_denied")
	public String showAccessDenied() {
		return "access-denied";
	}

}