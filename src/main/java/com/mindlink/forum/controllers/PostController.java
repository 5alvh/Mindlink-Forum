package com.mindlink.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindlink.forum.models.dtos.PostDtos.PostCreateDto;
import com.mindlink.forum.models.dtos.PostDtos.PostGetDto;
import com.mindlink.forum.models.dtos.PostDtos.PostUpdateDto;
import com.mindlink.forum.services.PostService;

@RestController
@RequestMapping("/blog")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/createPost")
    public ResponseEntity<PostGetDto> createPost(@RequestBody PostCreateDto postDto) {
        PostGetDto createdPost = postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @GetMapping("/")
    public ResponseEntity<List<PostGetDto>> getAllPosts() {
        List<PostGetDto> posts = postService.getAllPosts();
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostGetDto> getPostById(@PathVariable Long id) {
        PostGetDto post = postService.getPostById(id);
        return ResponseEntity.ok().body(post);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostGetDto> updatePost(@PathVariable Long postId, @RequestBody PostUpdateDto postDto) {
        PostGetDto updatedPost = postService.updatePost(postId, postDto);
        return ResponseEntity.ok().body(updatedPost);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}

