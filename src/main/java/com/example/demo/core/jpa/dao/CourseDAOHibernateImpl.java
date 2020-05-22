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
				currentSession.createQuery("from Course c ORDER BY c.id", Course.class);
		List<Course> Courses = theQuery.getResultList();
		return Courses;
	}

	@Override
	@Transactional
	public void saveCourse(Course course) {
		Session currentSession = entityManager.unwrap(Session.class);
		System.out.println(course.getId());
		// save/update the course
		currentSession.saveOrUpdate(course);
	}

	@Override
	@Transactional
	public Course getCourse(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Course course = currentSession.get(Course.class, id);
		return course;
	}

	@Override
	@Transactional
	public void deleteCourse(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Course where id=:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}
}
