package com.mindlink.forum.models.DTO.UserDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGetDto {

    private Long id;
    private String username;
    /*
    *private List<Post> posts;
    *private List<Like> likes;
    *private List<Comment> comments;
    */
}
