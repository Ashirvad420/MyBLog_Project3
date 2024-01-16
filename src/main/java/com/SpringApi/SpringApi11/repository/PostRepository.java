package com.SpringApi.SpringApi11.repository;

import com.SpringApi.SpringApi11.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
