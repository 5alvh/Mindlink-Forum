package com.mindlink.forum.utils;

import com.mindlink.forum.models.DTO.PostDtos.PostGetDto;
import com.mindlink.forum.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostGetDto postToPostGetDto(Post post);
    List<PostGetDto> postsToPostsGetDto(List<Post> posts);
}
