package com.Facebookrepo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.Facebookrepo.entity.FacebookUser;

@Repository
public interface FbDAOInterface extends JpaRepository<FacebookUser,Long> {

	@Query("from com.Facebookrepo.entity.FacebookUser fu where fu.username=:uname")
	public List<FacebookUser> findByName(String uname);

	
		
		
	
}
