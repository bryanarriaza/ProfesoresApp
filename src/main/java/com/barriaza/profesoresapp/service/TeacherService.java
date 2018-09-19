package com.barriaza.profesoresapp.service;

import java.util.List;

import com.barriaza.profesoresapp.model.Teacher;

public interface TeacherService {

	void save(Teacher teacher);

	void delete(Long idTeacher);

	void update(Teacher teacher);

	List<Teacher> findAllTeacher();

	Teacher findById(Long idTeacher);

	Teacher findByName(String nameTeacher);

}
