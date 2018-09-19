package com.barriaza.profesoresapp.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.barriaza.profesoresapp.dao.AbstractSession;
import com.barriaza.profesoresapp.dao.CourseDao;
import com.barriaza.profesoresapp.model.Course;

@Repository
@Transactional
public class CourseDaoImpl extends AbstractSession implements CourseDao {

	public void save(Course course) {
		getSession().persist(course);
	}

	public void delete(Long idCourse) {
		Course course = findById(idCourse);
		if (course != null) {
			getSession().delete(course);
		}
	}

	public void update(Course course) {
		getSession().update(course);
	}

	@SuppressWarnings({ "unchecked" })
	public List<Course> findAll() {
		return getSession().createQuery("from Course").list();
	}

	public Course findById(Long idCourse) {
		return (Course) getSession().get(Course.class, idCourse);
	}

	public Course findByName(String nameCourse) {
		return (Course) getSession().createQuery("from Course where name = :name").setParameter("name", nameCourse)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Course> findByIdTeacher(Long idTeacher) {
		return getSession().createQuery("from Course a join a.teacher t where t.idTeacher = :idTeacher")
				.setParameter("idTeacher", idTeacher).list();
	}

}
