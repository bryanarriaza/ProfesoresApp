package com.barriaza.profesoresapp.dao;

import java.util.List;

import com.barriaza.profesoresapp.model.SocialMedia;
import com.barriaza.profesoresapp.model.TeacherSocialMedia;

public interface SocialMediaDao {

	void save(SocialMedia socialMedia);

	void delete(Long idSocialMedia);

	void update(SocialMedia socialMedia);

	List<SocialMedia> findAll();

	SocialMedia findById(Long idSocialMedia);

	SocialMedia findByName(String nameSocialMedia);

	TeacherSocialMedia findBySocialMediaByIdAndName(Long idSocialMedia, String nickname);

}
