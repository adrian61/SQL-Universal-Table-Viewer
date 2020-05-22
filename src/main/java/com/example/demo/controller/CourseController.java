package com.example.demo.controller;

import com.example.demo.core.jpa.dao.CourseDAO;
import com.example.demo.core.jpa.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", method = RequestMethod.POST)
public class CourseController {
	private CourseDAO courseDAO;

	@Autowired
	public CourseController(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@GetMapping(value = "/courses")
	public List<Course> findAll() {
		return courseDAO.findAll();
	}
}