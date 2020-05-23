package com.example.demo.web.controller;

import com.example.demo.core.jpa.dao.TeacherDAO;
import com.example.demo.core.jpa.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api",method = RequestMethod.POST)
public class TeacherController {
	private TeacherDAO teacherDAO;

	@Autowired
	public TeacherController(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@PostMapping(value = "/teachers")
	public List<Teacher> findAll() {
		return teacherDAO.findAll();
	}
}
