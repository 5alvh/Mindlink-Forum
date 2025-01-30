package com.mindlink.forum.controllers;

import com.mindlink.forum.models.dtos.LikesDtos.LikeCreateDto;
import com.mindlink.forum.models.dtos.LikesDtos.LikeGetDto;
import com.mindlink.forum.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<LikeGetDto> likePost(@RequestBody LikeCreateDto likeCreateDto) {
        try {
            return ResponseEntity.ok().body(likeService.likePost(likeCreateDto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{postId}/{userId}")
    public ResponseEntity<Void> unlikePost(@PathVariable Long postId, @PathVariable Long userId) {
        try {
            likeService.unlikePost(postId, userId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<LikeGetDto>> getLikesForPost(@PathVariable Long postId) {
        try {
            return ResponseEntity.ok().body(likeService.getLikesForPost(postId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
