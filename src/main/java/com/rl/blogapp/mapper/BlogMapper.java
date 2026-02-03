package com.rl.blogapp.mapper;

import com.rl.blogapp.dto.BlogRequest;
import com.rl.blogapp.dto.BlogResponse;
import com.rl.blogapp.entity.Blog;
import com.rl.blogapp.entity.User;
import org.springframework.stereotype.Component;

@Component
public class BlogMapper {

    public BlogResponse toDto(Blog blog) {
        return new BlogResponse(
                blog.getId(),
                blog.getTitle(),
                blog.getContent(),
                blog.getAuthor().getName()
        );
    }

    public Blog toEntity(BlogRequest blogRequest, User author) {
        Blog blog = new Blog();
        blog.setTitle(blogRequest.getTitle());
        blog.setContent(blogRequest.getContent());
        blog.setAuthor(author);

        return blog;
    }
}
