package com.coforge.microservices.postservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.microservices.postservice.model.CommentsDto;
import com.coforge.microservices.postservice.model.Post;
import com.coforge.microservices.postservice.service.PostService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	PostService service;

	@GetMapping("/all")
	public List<Post> findAllPosts() {
		return service.findAllPosts();
	}

	@GetMapping("/test")
	public String test() {
		return "Hello Welcome";
	}

	@GetMapping("/comments/{postId}")
	@HystrixCommand(fallbackMethod="getDummyData")
	public List<CommentsDto> findCommentsByPostId(@PathVariable("postId") int postId) {
		return service.findCommentsByPostId(postId);
	}

	@GetMapping("/author/{postId}")
			public String findAuthor(@PathVariable("postId") int postId){
				return service.findAuthorByPostId(postId);
			}
	
	@GetMapping("/comments/port")
	public String getCommentAppPort() {
		System.out.println("Inside the port");
		return service.getCommentsAppPort();
	}
	
	public List<CommentsDto> getDummyData(@PathVariable("postId") int postId){
		List<CommentsDto> data = new ArrayList();
		data.add(new CommentsDto(1111,"rakesh",2222,"this is sample"));
		data.add(new CommentsDto(2222,"praveen",3333,"this is sample"));
		
		return data;
	}

}
