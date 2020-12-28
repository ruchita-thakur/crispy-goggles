package com.facebookjparepository.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.facebookjparepository.dao.FacebookDAOInterface;
import com.facebookjparepository.entity.FacebookUser;

@Component
public class FacebookDTO implements FacebookDTOInterface {
	
	@Autowired
	private FacebookDAOInterface fd;
	
	public FacebookUser createProfileDTO(FacebookUser fu) {
		return fd.save(fu);
	}
	
	public Optional<FacebookUser> viewProfileDTO(Long id) {
		return fd.findById(id);
		
	}
	
	public List<FacebookUser> viewAllProfileDTO(){
		 return fd.findAll();
				 
	}
	
	public int deleteProfileDTO(long id) {
		int i=0;
		fd.deleteById(id);
		i=1;
		return i;
	}
	
	public boolean searchProfileDTO(Long id) {
		return fd.existsById(id);
		
	}
	
	public FacebookUser searchProfileByNameDTO(String name) {
		return fd.searchProfileByName(name);
	}
	
	public int editProfileDTO(FacebookUser fu,Long id) {
		int i=0;
		fu.setUid(id);
		fd.save(fu);
		i=1;
		return i;
		
		
	}

}
