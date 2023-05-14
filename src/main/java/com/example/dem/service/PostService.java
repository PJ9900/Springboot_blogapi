package com.example.dem.service;

import java.util.List;

import com.example.dem.payload.PostDto;
import com.example.dem.payload.PostResponse;

//First we will change service package and then controller package Because 
// controller layer is depends on service layer;



public interface PostService {

	PostDto createPost(PostDto postDto);
	
	PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
	
	PostDto getPostById(Long id);
	
	PostDto updatePost(PostDto postDto, Long id);
	
	void deletePostById(Long id);
}
