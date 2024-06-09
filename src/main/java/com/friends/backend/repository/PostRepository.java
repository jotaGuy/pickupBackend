package com.friends.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.friends.backend.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
