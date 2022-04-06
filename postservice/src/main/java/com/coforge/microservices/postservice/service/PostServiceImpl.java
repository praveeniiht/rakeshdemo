package com.coforge.microservices.postservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coforge.microservices.postservice.model.CommentsDto;
import com.coforge.microservices.postservice.model.Post;
import com.coforge.microservices.postservice.repo.PostRepo;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostRepo repo;
	
	
	
	
	@Autowired
	PostFeignProxy template;

	@Override
	public List<Post> findAllPosts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}



	@Override
	public List<CommentsDto> findCommentsByPostId(int postId) {
		// TODO Auto-generated method stub
		
		
		List<CommentsDto> comments = template.findCommentsByPid(postId);
		return comments;
	}



	@Override
	public String findAuthorByPostId(int postId) {
		// TODO Auto-generated method stub
		return repo.findAuthor(postId);
	}

	@Override
	public String getCommentsAppPort() {
		return template.getCommentsPort();
	}

	

	

}
