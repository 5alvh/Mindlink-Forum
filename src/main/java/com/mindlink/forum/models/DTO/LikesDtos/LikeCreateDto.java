package com.mindlink.forum.models.DTO.LikesDtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeCreateDto {

    @NotNull(message = "Post ID cannot be null")
    @Positive(message = "Post ID must be greater than 0")
    private Long postId;

    @NotNull(message = "User ID cannot be null")
    @Positive(message = "User ID must be greater than 0")
    private Long userId;
}
