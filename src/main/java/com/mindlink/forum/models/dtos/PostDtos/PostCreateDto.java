package com.mindlink.forum.models.dtos.PostDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto {

    private String title;
    private String content;
    private String categoria;
    private Long userId;

}
