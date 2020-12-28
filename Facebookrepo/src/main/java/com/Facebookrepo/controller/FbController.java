package com.Facebookrepo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Facebookrepo.DAO.FbDAOInterface;
import com.Facebookrepo.entity.FacebookUser;
import com.Facebookrepo.service.FbServiceInterface;

@RestController
public class FbController {
	@Autowired
	private FbServiceInterface fi;

	@PostMapping("createprofilefacebook")
	public String createProfile(@RequestBody FacebookUser fu) {
		String str = "Registration failed";

		int i = fi.createProfileService(fu);
		if (i > 0) {
			str = "Record added successfully";
		}
		return str;

	}

	@DeleteMapping("deleteprofilefacebook/{uid}")
	public String deleteProfile(@PathVariable("uid") Long uid) {
		String str = "Profile not deleted";

		int i = fi.deleteProfileService(uid);
		if (i > 0) {
			str = "Profile deleted successfully!!!";
		}
		return str;
	}

	@GetMapping("viewprofilefacebook/{uid}")
	public Optional<FacebookUser> viewProfile(@PathVariable("uid") Long uid) {

		Optional<FacebookUser> i = fi.viewProfileService(uid);

		if (i != null) {
			System.out.println("Record found");

		} else {
			System.out.println("Record not found...");

		}

		return i;

	}

	@GetMapping("searchprofilefacebook/{username}")
	public List<FacebookUser> searchProfile(@PathVariable("username") String username) {
		List<FacebookUser> ll = new ArrayList<>();
		ll = fi.searchProfileService(username);

		return ll;
	}

	
	  @PutMapping("editprofilefacebook/{uid}") public String editProfile(@RequestBody FacebookUser fu,@PathVariable("uid") Long uid) 
	  { 
		  
		  String  str="Could not edit profile:/"; 
		
		  FacebookUser i=fi.editProfileService(fu, uid);
		  System.out.print(i.getAddress()+" "+i.getUsername()+""+i.getUid());
		  if(i!=null) { str="edited profile successfully"; } 
		  return str; 
		 }
	 

}
