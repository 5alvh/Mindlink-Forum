package com.mindlink.forum.services;

import com.mindlink.forum.models.dtos.PostDtos.PostCreateDto;
import com.mindlink.forum.models.dtos.PostDtos.PostGetDto;
import com.mindlink.forum.models.dtos.PostDtos.PostUpdateDto;

import java.util.List;

public interface PostService {
    PostGetDto createPost(PostCreateDto postDto);
    PostGetDto updatePost(Long postId, PostUpdateDto postDto);
    void deletePost(Long postId);
    List<PostGetDto> getAllPosts();
    PostGetDto getPostById(Long postId);
    //void likePost(Long postId, Long userId);
    //void commentPost(Long postId, Long userId, String content);
    //UserDto getPostCreator(Long postId);
}
