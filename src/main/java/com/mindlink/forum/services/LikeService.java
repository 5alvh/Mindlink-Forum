package com.mindlink.forum.services;

import com.mindlink.forum.models.dtos.LikesDtos.LikeCreateDto;
import com.mindlink.forum.models.dtos.LikesDtos.LikeGetDto;

import java.util.List;

public interface LikeService {
    LikeGetDto likePost(LikeCreateDto likeCreateDto);
    void unlikePost(Long postId, Long userId);
    List<LikeGetDto> getLikesForPost(Long postId);
}
