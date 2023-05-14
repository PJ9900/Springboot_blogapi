package com.example.dem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dem.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
