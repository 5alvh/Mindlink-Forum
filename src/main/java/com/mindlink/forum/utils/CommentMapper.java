package com.mindlink.forum.utils;

import java.util.List;

import org.mapstruct.Mapper;

import com.mindlink.forum.models.Comment;
import com.mindlink.forum.models.DTO.CommentDtos.CommentGetDto;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentGetDto commentToCommentGetDto(Comment comment);
    List<CommentGetDto> commentsToCommentGetDto(List<Comment> comments);
}
