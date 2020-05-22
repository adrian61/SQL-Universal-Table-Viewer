package com.example.demo.core.jpa.dao;

import com.example.demo.core.jpa.domain.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class TeacherDAOHibernateImpl implements TeacherDAO {
	private EntityManager entityManager;

	@Autowired
	public TeacherDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Teacher> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Teacher> theQuery =
				currentSession.createQuery("from Teacher", Teacher.class);
		List<Teacher> Teachers = theQuery.getResultList();
		return Teachers;
	}
}
