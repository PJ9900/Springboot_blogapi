package com.example.dem.payload;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {

	private Long id;
	// title should not be null or empty
	// title should have at least 2 characters
	@NotEmpty
	@Size(min = 2, message = "post title should have atleast 2 characters")
	private String title;
	
	// post description shold be not null or empty
	// post description should have at least 10 characters
	@NotEmpty
	@Size(min=10, message ="post description should have at least 10 characters")
	private String description;
	
	// post content should not be nnull or empty
	@NotEmpty
	private String content;
	private Set<CommentDto> comments;
}
