package com.barriaza.profesoresapp.dao;

import java.util.List;

import com.barriaza.profesoresapp.model.Course;

public interface CourseDao {

	void save(Course course);

	void update(Course course);

	void delete(Long idCourse);

	List<Course> findAll();

	Course findById(Long idCourse);

	Course findByName(String nameCourse);

	List<Course> findByIdTeacher(Long idTeacher);

}
