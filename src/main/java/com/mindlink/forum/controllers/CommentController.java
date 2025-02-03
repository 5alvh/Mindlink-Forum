package com.mindlink.forum.controllers;

import com.mindlink.forum.models.dtos.CommentDtos.CommentCreateDto;
import com.mindlink.forum.models.dtos.CommentDtos.CommentGetDto;
import com.mindlink.forum.models.dtos.CommentDtos.CommentUpdateDto;
import com.mindlink.forum.services.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentGetDto> createComment(@Valid @RequestBody CommentCreateDto comment) {
        return ResponseEntity.ok(commentService.createComment(comment));
    }

    @GetMapping
    public ResponseEntity<List<CommentGetDto>> getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentGetDto> getCommentById(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentGetDto> updateComment(@PathVariable Long id, @Valid @RequestBody CommentUpdateDto comment) {
        return ResponseEntity.ok(commentService.updateComment(id, comment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/commentByPost/{postId}")
    public ResponseEntity<List<CommentGetDto>> getCommentsByPostId(@PathVariable Long postId){
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }
}
