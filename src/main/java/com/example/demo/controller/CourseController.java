package com.example.demo.controller;

import com.example.demo.core.jpa.dao.CourseDAO;
import com.example.demo.core.jpa.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
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