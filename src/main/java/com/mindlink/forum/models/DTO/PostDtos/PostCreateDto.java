package com.mindlink.forum.models.DTO.PostDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto {

    private String title;
    private String content;
    private String categoria;
    private MultipartFile image;
    private Long userId;

}
