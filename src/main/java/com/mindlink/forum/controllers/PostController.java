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

import com.mindlink.forum.models.DTO.PostDtos.PostCreateDto;
import com.mindlink.forum.models.DTO.PostDtos.PostGetDto;
import com.mindlink.forum.models.DTO.PostDtos.PostUpdateDto;
import com.mindlink.forum.services.PostService;

@RestController
@RequestMapping("/blog")
public class PostController {

    PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/createPost")
    public ResponseEntity<PostGetDto> createPost(@RequestBody PostCreateDto postDto) {
        try {
            return ResponseEntity.ok().body(postService.createPost(postDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<PostGetDto>> getAllPosts() {
        try {
            return ResponseEntity.ok().body(postService.getAllPosts());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostGetDto> getPostById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(postService.getPostById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostGetDto> updatePost(@PathVariable Long postId, @RequestBody PostUpdateDto postDto) {
        try {
            return ResponseEntity.ok().body(postService.updatePost(postId, postDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        try {
            postService.deletePost(postId);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
