package com.coforge.microservices.postservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coforge.microservices.postservice.model.Post;


@Repository
public interface PostRepo extends JpaRepository<Post,Integer>{
	
	@Query("select u.author from Post u where u.pid=?1")
	public String findAuthor(int postId);

}
