package com.example.demo.core.jpa.dao;

import com.example.demo.core.jpa.domain.Course;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOHibernateImpl implements CourseDAO {
	private EntityManager entityManager;

	@Autowired
	public CourseDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Course> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Course> theQuery =
				currentSession.createQuery("from Course", Course.class);
		List<Course> Courses = theQuery.getResultList();
		return Courses;
	}
}
