package com.facebookjparepository.service;

import java.util.List;
import java.util.Optional;

import com.facebookjparepository.entity.FacebookUser;

public interface FacebookServiceInterface {
	
	public FacebookUser createProfileService(FacebookUser fu);
	
	public Optional<FacebookUser> viewProfileService(Long id);
	
	public List<FacebookUser> viewAllProfileService();
	
	public int deleteProfileService(long id);
	
	public boolean searchProfileService(Long id);
	
	public FacebookUser searchProfileByNameService(String name);
	
	public int editProfileService(FacebookUser fu,Long id);
	
	

}
