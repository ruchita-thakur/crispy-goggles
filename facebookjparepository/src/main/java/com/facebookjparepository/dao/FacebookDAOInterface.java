package com.facebookjparepository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facebookjparepository.entity.FacebookUser;

public interface FacebookDAOInterface extends JpaRepository<FacebookUser, Long>{
	
	@Query("select c from FacebookUser c where c.username=:name")
	public FacebookUser searchProfileByName(String name);
	
	
}
