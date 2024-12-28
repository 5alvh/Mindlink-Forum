package com.mindlink.forum.services;

import com.mindlink.forum.models.DTO.CommentDtos.CommentCreateDto;
import com.mindlink.forum.models.DTO.CommentDtos.CommentGetDto;
import com.mindlink.forum.models.DTO.CommentDtos.CommentUpdateDto;

import java.util.List;

public interface CommentService {
    CommentGetDto getCommentById(Long id);
    List<CommentGetDto> getAllComments();
    CommentGetDto createComment(CommentCreateDto comment);
    CommentGetDto updateComment(Long id, CommentUpdateDto comment);
    void deleteComment(Long id);
}
