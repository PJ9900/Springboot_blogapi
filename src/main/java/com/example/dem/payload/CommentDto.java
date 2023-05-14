package com.example.dem.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {
	
	private Long id;

	// name should not be null or empty
	@NotEmpty(message = "Name should not be empty or null")
	private String name;
	
	// email should not be null or Empty
	// email field validation
	@NotEmpty(message = "Email should not be empty or null")
	@Email
	private String email;
	
	// comment body should not be null or empty
	// Comment body must be minimum 10 characters
	@NotEmpty
	@Size(min = 10, message = "Comment body must be minimum 10 characters")
	private String body;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private String commentRequest;
}
