package com.mindlink.forum.services;

import com.mindlink.forum.models.dtos.LikesDtos.LikeCreateDto;
import com.mindlink.forum.models.dtos.LikesDtos.LikeGetDto;

import java.util.List;

public interface LikeService {
    void likePost(LikeCreateDto likeCreateDto);
    List<LikeGetDto> getLikesForPost(Long postId);
}
