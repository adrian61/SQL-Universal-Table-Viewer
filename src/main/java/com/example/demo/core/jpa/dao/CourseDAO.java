package com.example.demo.core.jpa.dao;

import com.example.demo.core.jpa.domain.Course;

import java.util.List;

public interface CourseDAO {
	public List<Course> findAll();
}
