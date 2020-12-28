package com.Facebookrepo.service;

import java.util.List;
import java.util.Optional;

import com.Facebookrepo.entity.FacebookUser;

public interface FbServiceInterface {

	public int createProfileService(FacebookUser fu);
	public int deleteProfileService(Long uid);
	public Optional<FacebookUser> viewProfileService(Long uid);
	public  List<FacebookUser> searchProfileService(String username);
	public FacebookUser editProfileService(FacebookUser fu,Long uid);
}
