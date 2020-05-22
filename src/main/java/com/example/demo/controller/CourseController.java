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

	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		course.setId(0);
		courseDAO.saveCourse(course);
		return course;
	}
}