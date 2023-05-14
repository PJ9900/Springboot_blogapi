package com.example.dem.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

	private List<PostDto> content;
	private int pageNO;
	private int pageSize;
	private Long totalElements;
	private int totalPages;
	private boolean last;
}
