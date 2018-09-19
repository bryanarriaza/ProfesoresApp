package com.barriaza.profesoresapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.barriaza.profesoresapp.model.SocialMedia;
import com.barriaza.profesoresapp.service.SocialMediaService;
import com.barriaza.profesoresapp.util.CustomErrorType;

@Controller
@RequestMapping("/v1")
public class SocialMediaController {

	@Autowired
	SocialMediaService socialMediaService;

	// GET ALL
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/socialMedias", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<SocialMedia>> getSocialMedias(
			@RequestParam(value = "name", required = false) String name) {
		List<SocialMedia> socialMedias = new ArrayList<>();

		if (name == null) {
			socialMedias = socialMediaService.findAll();
			if (socialMedias.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<SocialMedia>>(socialMedias, HttpStatus.OK);
		} else {
			SocialMedia socialMedia = socialMediaService.findByName(name);
			if (socialMedia == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			socialMedias.add(socialMedia);
			return new ResponseEntity<List<SocialMedia>>(socialMedias, HttpStatus.OK);
		}
	}

	// GET
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<SocialMedia> getSocialMedia(@PathVariable("id") Long _idSocialMedia) {
		if (_idSocialMedia == null || _idSocialMedia <= 0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		SocialMedia socialMedia = socialMediaService.findById(_idSocialMedia);
		if (socialMedia == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<SocialMedia>(socialMedia, HttpStatus.OK);
	}

	// POST
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/socialMedias", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createSocialMedia(@RequestBody SocialMedia _socialMedia,
			UriComponentsBuilder uriComponentsBuilder) {
		if (_socialMedia.getName().equals(null) || _socialMedia.getName().isEmpty()) {
			return new ResponseEntity(new CustomErrorType("idSocialMedia is required"), HttpStatus.CONFLICT);
			// return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		if (socialMediaService.findByName(_socialMedia.getName()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		socialMediaService.save(_socialMedia);
		SocialMedia socialMediaVal = socialMediaService.findByName(_socialMedia.getName());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/v1/socialMedias/{id}")
				.buildAndExpand(socialMediaVal.getIdSocialMedia()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.OK);
	}

	// UPDATE
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<?> updateSocialMedia(@PathVariable("id") Long _idSocialMedia,
			@RequestBody SocialMedia _socialMedia) {
		if (_idSocialMedia == null || _idSocialMedia <= 0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		SocialMedia currentSocialMedia = socialMediaService.findById(_idSocialMedia);
		if (currentSocialMedia == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		currentSocialMedia.setName(_socialMedia.getName());
		currentSocialMedia.setIcon(_socialMedia.getIcon());
		socialMediaService.update(currentSocialMedia);
		return new ResponseEntity<SocialMedia>(currentSocialMedia, HttpStatus.OK);
	}

	// DELETE
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteSocialMedia(@PathVariable("id") Long _idSocialMedia,
			@RequestBody SocialMedia _socialMedia) {
		if (_idSocialMedia == null || _idSocialMedia <= 0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		SocialMedia currentSocialMedia = socialMediaService.findById(_idSocialMedia);
		if (currentSocialMedia == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		socialMediaService.delete(_idSocialMedia);
		return new ResponseEntity<SocialMedia>(currentSocialMedia, HttpStatus.OK);
	}

}
