package com.mindlink.forum.models.DTO.PostDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostGetDto {

    private String title;
    private String content;
    private String categoria;

}
