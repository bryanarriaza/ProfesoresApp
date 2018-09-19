package com.barriaza.profesoresapp.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barriaza.profesoresapp.dao.CourseDao;
import com.barriaza.profesoresapp.model.Course;
import com.barriaza.profesoresapp.service.CourseService;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	public void save(Course course) {
		courseDao.save(course);
	}

	public void update(Course course) {
		courseDao.update(course);
	}

	public void delete(Long idCourse) {
		courseDao.delete(idCourse);
	}

	public List<Course> findAll() {
		return courseDao.findAll();
	}

	public Course findById(Long idCourse) {
		return courseDao.findById(idCourse);
	}

	public Course findByName(String nameCourse) {
		return courseDao.findByName(nameCourse);
	}

	public List<Course> findByIdTeacher(Long idTeacher) {
		return courseDao.findByIdTeacher(idTeacher);
	}

}
