package com.rl.blogapp.repository;

import com.rl.blogapp.entity.Blog;
import com.rl.blogapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    Optional<Blog> findByIdAndAuthor(Long id, User author);
    List<Blog> findByAuthor(User author);
}
