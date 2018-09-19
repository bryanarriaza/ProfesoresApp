package com.barriaza.profesoresapp.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.barriaza.profesoresapp.dao.AbstractSession;
import com.barriaza.profesoresapp.dao.TeacherDao;
import com.barriaza.profesoresapp.model.Teacher;
import com.barriaza.profesoresapp.model.TeacherSocialMedia;

@Repository
@Transactional
public class TeacherDaoImpl extends AbstractSession implements TeacherDao {

	public void save(Teacher teacher) {
		getSession().persist(teacher);
	}

	public void update(Teacher teacher) {
		getSession().update(teacher);
	}

	public void delete(Long idTeacher) {
		Teacher teacher = findById(idTeacher);
		if (teacher != null) {
			Iterator<TeacherSocialMedia> i = teacher.getTeacherSocialMedia().iterator();
			while (i.hasNext()) {
				TeacherSocialMedia teacherSocialMedia = i.next();
				i.remove();
				getSession().delete(teacherSocialMedia);
			}
			teacher.getTeacherSocialMedia().clear();
			getSession().delete(teacher);
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Teacher> findAllTeacher() {
		return getSession().createQuery("from Teacher").list();
	}

	public Teacher findById(Long idTeacher) {
		return (Teacher) getSession().get(Teacher.class, idTeacher);
	}

	public Teacher findByName(String nameTeacher) {
		return (Teacher) getSession().createQuery("from Teacher where name = :name").setParameter("name", nameTeacher)
				.uniqueResult();
	}

}
