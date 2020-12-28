package com.facebookjparepository.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.facebookjparepository.entity.FacebookUser;
import com.facebookjparepository.service.FacebookServiceInterface;


@RestController
public class FacebookController {
	
	@Autowired
	private FacebookServiceInterface fs;
	
	@PostMapping("createprofilefacebook")
	public String createProfile(@RequestBody FacebookUser fu) {
		String str="Registration fail";
		FacebookUser i=fs.createProfileService(fu);
		if(i!=null)
		{
			str="Registration success";
		}
		return str;
		
	}
	
	@GetMapping("viewprofilefacebook")
	public Optional<FacebookUser> viewProfile(@PathParam("id") Long id) {
		Optional<FacebookUser> fb;
		 fb =fs.viewProfileService(id);
		 return fb;
		
	}
	
	@GetMapping("viewAllprofilefacebook")
	public List<FacebookUser> viewAllProfile() {
		List<FacebookUser> ll=fs.viewAllProfileService();
		return ll;
		
	}
	
	@DeleteMapping("deleteprofilefacebook")
	public String deleteProfile(@PathParam("id") Long id) {
		String str="Pofile not deleted";
		int i= fs.deleteProfileService(id);
		if(i>0) {
			str="Profile deleted";
		}
		return str;
		
	}
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Profile with this id not present")
    @ExceptionHandler({Exception.class})
    public void handleException() {
      
    }
    @ExceptionHandler({SQLException.class,DataAccessException.class})
      public String databaseError() {
        return "Profile with this id not present in your database";
      }
	
	@PostMapping("searchprofilefacebook")
	public String searchProfile(@PathParam("id") Long id) {
		String str="Profile not found";
		boolean f=fs.searchProfileService(id);
		if(f!=false)
		{
			str="Profile found";
		}
		
		return str;
	}
	
	@PostMapping("searchprofilebynamefacebook")
	public FacebookUser searchProfileName(@PathParam("name") String name) {
		FacebookUser f=fs.searchProfileByNameService(name);
		return f;
	}

	
	@PutMapping("editprofilefacebook")
	public String editProfile(@RequestBody FacebookUser fu,@PathParam("id") Long id) {
		String str="Pofile not edited";
		int i= fs.editProfileService(fu, id);
		if(i>0) {
			str="Profile edited";
		}
		return str;
		
		
		
		
	}
	

}
