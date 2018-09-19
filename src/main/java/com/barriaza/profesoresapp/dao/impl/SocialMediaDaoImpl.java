package com.barriaza.profesoresapp.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.barriaza.profesoresapp.dao.AbstractSession;
import com.barriaza.profesoresapp.dao.SocialMediaDao;
import com.barriaza.profesoresapp.model.SocialMedia;
import com.barriaza.profesoresapp.model.TeacherSocialMedia;

@Repository
@Transactional
public class SocialMediaDaoImpl extends AbstractSession implements SocialMediaDao {

	public void save(SocialMedia socialMedia) {
		getSession().persist(socialMedia);
	}

	public void delete(Long idSocialMedia) {
		SocialMedia socialMedia = findById(idSocialMedia);
		if (socialMedia != null) {
			getSession().delete(socialMedia);
		}
	}

	public void update(SocialMedia socialMedia) {
		getSession().update(socialMedia);
	}

	@SuppressWarnings("unchecked")
	public List<SocialMedia> findAll() {
		return getSession().createQuery("from SocialMedia").list();
	}

	public SocialMedia findById(Long idSocialMedia) {
		return (SocialMedia) getSession().get(SocialMedia.class, idSocialMedia);
	}

	public SocialMedia findByName(String nameSocialMedia) {
		return (SocialMedia) getSession().createQuery("from SocialMedia where name =:name").setParameter("name", nameSocialMedia).uniqueResult();
	}
	
	public TeacherSocialMedia findBySocialMediaByIdAndName(Long idSocialMedia, String nickname) {

		@SuppressWarnings("unchecked")
		List<Object[]> objects = getSession().createQuery(
				"from TeacherSocialMedia tsm join tsm.socialMedia sm where tsm.idSocialMedia = :idSocialMedia and tsm.name = :nickname")
				.setParameter("idSocialMedia", idSocialMedia).setParameter("nickname", nickname).list();
		if (objects.size() > 0) {
			for (Object object : objects) {
				if (object instanceof TeacherSocialMedia) {
					return (TeacherSocialMedia) object;
				}
			}
		}

		return (TeacherSocialMedia) getSession().createQuery(
				"from TeacherSocialMedia tsm join tsm.socialMedia sm where tsm.idSocialMedia = :idSocialMedia and tsm.name = :nickname")
				.setParameter("idSocialMedia", idSocialMedia).setParameter("nickname", nickname).list();
	}

}
