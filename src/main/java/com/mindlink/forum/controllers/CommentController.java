package com.mindlink.forum.controllers;

import com.mindlink.forum.models.DTO.CommentDtos.CommentCreateDto;
import com.mindlink.forum.models.DTO.CommentDtos.CommentGetDto;
import com.mindlink.forum.models.DTO.CommentDtos.CommentUpdateDto;
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

    @PostMapping("/")
    public ResponseEntity<CommentGetDto> createComment(@RequestBody CommentCreateDto comment) {
        try{
            return ResponseEntity.ok().body(commentService.createComment(comment));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<CommentGetDto>> getAllComments() {
        try {
            return ResponseEntity.ok().body(commentService.getAllComments());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentGetDto> getCommentById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(commentService.getCommentById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentGetDto> updateComment(@PathVariable Long id, @RequestBody CommentUpdateDto comment) {
        try {
            return ResponseEntity.ok().body(commentService.updateComment(id, comment));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        try {
            commentService.deleteComment(id);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
