package com.mindlink.forum.models.dtos.UserDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGetDto {

    private Long id;
    private String username;

}
