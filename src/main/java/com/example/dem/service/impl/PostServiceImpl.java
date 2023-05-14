package com.example.dem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dem.entity.Post;
import com.example.dem.exception.ResourceNotFoundException;
import com.example.dem.payload.PostDto;
import com.example.dem.payload.PostResponse;
import com.example.dem.repository.PostRepository;
import com.example.dem.service.PostService;


@Service
public class PostServiceImpl implements PostService{

	private PostRepository postRepository;
	
	private ModelMapper mapper;
	
	public PostServiceImpl(PostRepository postRepository, ModelMapper mapper) {
		this.postRepository = postRepository;
		this.mapper = mapper;
	}



	@Override
	public PostDto createPost(PostDto postDto) {
		
		// convert DTO to entity
		
		Post post = mapToEntity(postDto);
		
		Post newPost = postRepository.save(post);
		
		// convert entity to DTD
		PostDto postResponse = mapToDTO(newPost);
		
		return postResponse;
	}



	@Override
	public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		
		// create Pageable instance
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);// .descending()); for sort by descending
		
		Page<Post> posts = postRepository.findAll(pageable);
		
		// get content for page object
		List<Post> listOfPosts = posts.getContent();
		
		List<PostDto> content = listOfPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(content);
		postResponse.setPageNO(pageNo);
		postResponse.setPageSize(pageSize);
		postResponse.setTotalElements(posts.getTotalElements());
		postResponse.setTotalPages(posts.getTotalPages());
		postResponse.setLast(posts.isLast());
		
		return postResponse;
	}
	
	
	// convert Entity to DTO
	private PostDto mapToDTO(Post post) {
		
		PostDto postDto = mapper.map(post, PostDto.class);
		
//		PostDto postDto = new PostDto();
//		postDto.setId(post.getId());
//		postDto.setTitle(post.getTitle());
//		postDto.setDescription(post.getDescription());
//		postDto.setContent(post.getContent());
		return postDto;
	}
	
	// convert DTO to Entity
	private Post mapToEntity(PostDto postDto) {
		Post post = mapper.map(postDto, Post.class);
		
//		Post post = new Post();
//		post.setTitle(postDto.getTitle());
//		post.setDescription(postDto.getDescription());
//		post.setContent(postDto.getContent());
		return post;
	}



	@Override
	public PostDto getPostById(Long id) {
		
		Post post = postRepository.findById(id).orElseThrow();
		return mapToDTO(post);
	}



	@Override
	public PostDto updatePost(PostDto postDto, Long id) {
		// get post by id from the database
		Post post = postRepository.findById(id).orElseThrow();
		
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		
		Post updatedPost = postRepository.save(post);
		
		
		return mapToDTO(updatedPost);
	}



	@Override
	public void deletePostById(Long id) {
		
		// get post by id from the database
				Post post = postRepository.findById(id).orElseThrow();
				postRepository.delete(post);
		
	}

}
