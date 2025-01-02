package com.mindlink.forum.services;

import com.mindlink.forum.models.DTO.LikesDtos.LikeCreateDto;
import com.mindlink.forum.models.DTO.LikesDtos.LikeGetDto;
import com.mindlink.forum.models.Like;

import java.util.List;

public interface LikeService {
    LikeGetDto createLike(LikeCreateDto likeCreateDto);
    LikeGetDto likePost(LikeCreateDto likeCreateDto);
    void unlikePost(Long postId, Long userId);
    List<LikeGetDto> getLikesForPost(Long postId);
}
