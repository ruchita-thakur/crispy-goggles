package com.facebookjparepository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebookjparepository.dao.FacebookDAOInterface;
import com.facebookjparepository.dto.FacebookDTOInterface;
import com.facebookjparepository.entity.FacebookUser;

@Service
public class FacebookService implements FacebookServiceInterface {
	
	@Autowired
	private FacebookDTOInterface fdto;
	
	public FacebookUser createProfileService(FacebookUser fu) {
		return fdto.createProfileDTO(fu);
	}
	
	public Optional<FacebookUser> viewProfileService(Long id) {
		return fdto.viewProfileDTO(id);
		
	}
	
	public List<FacebookUser> viewAllProfileService(){
		 return fdto.viewAllProfileDTO();
				 
	}
	
	public int deleteProfileService(long id) {
		int i=0;
		fdto.deleteProfileDTO(id);
		i=1;
		return i;
	}
	
	public boolean searchProfileService(Long id) {
		return fdto.searchProfileDTO(id);
		
	}
	
	public FacebookUser searchProfileByNameService(String name) {
		return fdto.searchProfileByNameDTO(name);
	}
	
	public int editProfileService(FacebookUser fu,Long id) {
		return fdto.editProfileDTO(fu, id);
		
	}

}
