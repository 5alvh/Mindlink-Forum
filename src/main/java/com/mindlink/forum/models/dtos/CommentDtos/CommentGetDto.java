package com.mindlink.forum.models.dtos.CommentDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentGetDto {

    private Long id;
    private String content;
    private LocalDate fechaCreacion;
}
