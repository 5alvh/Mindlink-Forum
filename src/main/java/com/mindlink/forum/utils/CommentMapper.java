package com.mindlink.forum.utils;

import com.mindlink.forum.models.Comment;
import com.mindlink.forum.models.DTO.CommentDtos.CommentGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentGetDto commentToCommentGetDto(Comment comment);
    List<CommentGetDto> commentsToCommentGetDtos(List<Comment> comments);
}
