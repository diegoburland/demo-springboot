package com.demo.springboot.demo.repository;

import com.demo.springboot.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{

}
