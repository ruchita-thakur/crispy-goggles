package com.facebookjparepository.dto;



import java.util.List;
import java.util.Optional;

import com.facebookjparepository.entity.FacebookUser;

public interface FacebookDTOInterface {
	
	public FacebookUser createProfileDTO(FacebookUser fu);
	
	public Optional<FacebookUser> viewProfileDTO(Long id);
	
	public List<FacebookUser> viewAllProfileDTO();
	
	public int deleteProfileDTO(long id) ;
	
	public boolean searchProfileDTO(Long id);
	
	public FacebookUser searchProfileByNameDTO(String name);
	
	public int editProfileDTO(FacebookUser fu,Long id);
	
	

}

