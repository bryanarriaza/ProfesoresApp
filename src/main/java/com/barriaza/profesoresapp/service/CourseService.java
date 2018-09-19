package com.barriaza.profesoresapp.service;

import java.util.List;

import com.barriaza.profesoresapp.model.Course;

public interface CourseService {

	void save(Course course);

	void update(Course course);

	void delete(Long idCourse);

	List<Course> findAll();

	Course findById(Long idCourse);

	Course findByName(String nameCourse);

	List<Course> findByIdTeacher(Long idTeacher);

}
