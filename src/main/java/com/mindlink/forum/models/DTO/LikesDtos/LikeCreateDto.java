package com.mindlink.forum.models.DTO.LikesDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeCreateDto {
    private Long postId;
    private Long userId;
}
