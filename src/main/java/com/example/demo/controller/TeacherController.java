package com.example.demo.controller;

import com.example.demo.core.jpa.dao.TeacherDAO;
import com.example.demo.core.jpa.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {
	private TeacherDAO teacherDAO;

	@Autowired
	public TeacherController(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@GetMapping(value = "/teachers")
	public List<Teacher> findAll() {
		return teacherDAO.findAll();
	}
}
