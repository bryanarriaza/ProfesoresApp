package com.barriaza.profesoresapp.dao;

import java.util.List;

import com.barriaza.profesoresapp.model.Teacher;

public interface TeacherDao {

	void save(Teacher teacher);

	void delete(Long idTeacher);

	void update(Teacher teacher);

	List<Teacher> findAllTeacher();

	Teacher findById(Long idTeacher);

	Teacher findByName(String nameTeacher);

}
