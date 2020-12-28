package com.Facebookrepo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Facebookrepo.DAO.FbDAOInterface;
import com.Facebookrepo.entity.FacebookUser;

@Service
public class FbService implements FbServiceInterface{

	@Autowired
	FbDAOInterface fd;
	
	public int createProfileService(FacebookUser fu) {
		int i=0;
		fd.save(fu);
		i=1;
		return i;
	}

	@Override
	@Transactional
	public int deleteProfileService(Long uid) {
		// TODO Auto-generated method stub
		int i=0;
		fd.deleteById(uid);
		i=1;
		return i;
	}

	@Override
	public Optional<FacebookUser> viewProfileService(Long uid) {
		// TODO Auto-generated method stub
		
		Optional<FacebookUser> fu=fd.findById(uid);
		
		
		return fu;
	}

	@Override
	public List<FacebookUser> searchProfileService(String username) {
		// TODO Auto-generated method stub
		
		List<FacebookUser> list=new ArrayList<>();
		list=fd.findByName(username);

		return list;
	}


	@Transactional
	public FacebookUser editProfileService(FacebookUser fu,Long uid) {
		// TODO Auto-generated method stub
		return fd.saveAndFlush(fu);
		
		
	}
	


}