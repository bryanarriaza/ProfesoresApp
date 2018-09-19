package com.barriaza.profesoresapp.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barriaza.profesoresapp.dao.TeacherDao;
import com.barriaza.profesoresapp.model.Teacher;
import com.barriaza.profesoresapp.service.TeacherService;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;

	public void save(Teacher teacher) {
		teacherDao.save(teacher);
	}

	public void delete(Long idTeacher) {
		teacherDao.delete(idTeacher);
	}

	public void update(Teacher teacher) {
		teacherDao.update(teacher);
	}

	public List<Teacher> findAllTeacher() {
		return teacherDao.findAllTeacher();
	}

	public Teacher findById(Long idTeacher) {
		return teacherDao.findById(idTeacher);
	}

	public Teacher findByName(String nameTeacher) {
		return teacherDao.findByName(nameTeacher);
	}

}
