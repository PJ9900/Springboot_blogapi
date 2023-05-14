package com.example.dem.service;

import java.util.List;

import com.example.dem.payload.CommentDto;

public interface CommentService {

	CommentDto createComment(Long postId, CommentDto commentDto);
	
	List<CommentDto> getCommentsByPostId(Long postId);
	
	CommentDto getCommentById(Long  postId, Long commentId);
	
	CommentDto updateComment(Long postId, Long commentId, CommentDto commentRequest);

	void deleteComment(Long postId, Long commentId);

}
