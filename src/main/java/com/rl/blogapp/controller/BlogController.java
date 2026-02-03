package com.rl.blogapp.controller;

import com.rl.blogapp.dto.BlogRequest;
import com.rl.blogapp.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Blog APIs",
        description = "CRUD operations for blogs"
)
@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Operation(
            summary = "Create a blog",
            description = "User can create their own blog"
    )
    @PostMapping
    public ResponseEntity<?> createBlog(
            @RequestBody BlogRequest blogRequest,
            Authentication authentication
    ) {
        String email = authentication.getName();
        return new ResponseEntity<>(blogService.createBlog(blogRequest, email), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update a blog",
            description = "User can update their own blog"
    )
    @PutMapping("/{blogId}")
    public ResponseEntity<?> updateBlog(
            @PathVariable Long blogId,
            @RequestBody BlogRequest blogRequest,
            Authentication authentication
    ) {
        String email = authentication.getName();
        return new ResponseEntity<>(blogService.updateBlog(blogId, blogRequest, email), HttpStatus.OK);
    }

    @Operation(
            summary = "Delete a blog",
            description = "User can delete their own blog"
    )
    @DeleteMapping("/{blogId}")
    public ResponseEntity<?> deleteBlog(
            @PathVariable Long blogId,
            Authentication authentication
    ) {
        String email = authentication.getName();
        blogService.deleteBlog(blogId, email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "View own blog",
            description = "User can view their own blog"
    )
    @GetMapping("/me")
    public ResponseEntity<?> getBlogs(
            Authentication authentication
    ) {
        String email = authentication.getName();
        return new ResponseEntity<>(blogService.getBlogs(email), HttpStatus.OK);
    }

    @Operation(
            summary = "View all blogs",
            description = "User can view all the blogs"
    )
    @GetMapping
    public ResponseEntity<?> getAllBlogs() {
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }
}
