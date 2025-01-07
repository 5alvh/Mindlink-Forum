package com.mindlink.forum.models.DTO.CommentDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateDto {

    @NotBlank(message = "Content cannot be blank.")
    @Size(max = 1000, message = "Content must not exceed 1000 characters.")
    private String content;

    @NotNull(message = "Post ID is required.")
    private Long postId;

    @NotNull(message = "User ID is required.")
    private Long userId;

}
