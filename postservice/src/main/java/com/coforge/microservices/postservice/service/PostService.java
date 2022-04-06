package com.coforge.microservices.postservice.service;

import java.util.List;

import com.coforge.microservices.postservice.model.CommentsDto;
import com.coforge.microservices.postservice.model.Post;

public interface PostService {
	public List<Post> findAllPosts();
	public List<CommentsDto> findCommentsByPostId(int postId);
	
	public String findAuthorByPostId(int postId);
	public String getCommentsAppPort();

}
