package com.mindlink.forum.controllers;

import com.mindlink.forum.models.dtos.CommentDtos.CommentCreateDto;
import com.mindlink.forum.models.dtos.CommentDtos.CommentGetDto;
import com.mindlink.forum.models.dtos.CommentDtos.CommentUpdateDto;
import com.mindlink.forum.services.CommentService;
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
    public ResponseEntity<CommentGetDto> createComment(@RequestBody CommentCreateDto comment) {
        try{

            return ResponseEntity.ok().body(commentService.createComment(comment));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CommentGetDto>> getAllComments() {
        try {
            List<CommentGetDto> comments = commentService.getAllComments();
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentGetDto> getCommentById(@PathVariable Long id) {
        try {
            CommentGetDto comment = commentService.getCommentById(id);
            return ResponseEntity.ok().body(comment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentGetDto> updateComment(@PathVariable Long id, @RequestBody CommentUpdateDto comment) {
        try {
            CommentGetDto updatedComment = commentService.updateComment(id, comment);
            return ResponseEntity.ok().body(updatedComment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        try {
            commentService.deleteComment(id);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/commentByPost/{postId}")
    public List<CommentGetDto> getCommentsByPostId(@PathVariable Long postId){
        return commentService.getCommentsByPostId(postId);
    }
}
