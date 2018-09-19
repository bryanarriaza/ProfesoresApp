package com.barriaza.profesoresapp.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barriaza.profesoresapp.dao.SocialMediaDao;
import com.barriaza.profesoresapp.model.SocialMedia;
import com.barriaza.profesoresapp.model.TeacherSocialMedia;
import com.barriaza.profesoresapp.service.SocialMediaService;

@Service("socialMediaService")
@Transactional
public class SocialMediaServiceImpl implements SocialMediaService {

	@Autowired
	private SocialMediaDao socialMediaDao;

	public void save(SocialMedia socialMedia) {
		socialMediaDao.save(socialMedia);
	}

	public void delete(Long idSocialMedia) {
		socialMediaDao.delete(idSocialMedia);
	}

	public void update(SocialMedia socialMedia) {
		socialMediaDao.update(socialMedia);
	}

	public List<SocialMedia> findAll() {
		return socialMediaDao.findAll();
	}

	public SocialMedia findById(Long idSocialMedia) {
		return socialMediaDao.findById(idSocialMedia);
	}

	public SocialMedia findByName(String nameSocialMedia) {
		return socialMediaDao.findByName(nameSocialMedia);
	}

	public TeacherSocialMedia findBySocialMediaByIdAndName(Long idSocialMedia, String nickname) {
		return socialMediaDao.findBySocialMediaByIdAndName(idSocialMedia, nickname);
	}

}
