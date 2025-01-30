package com.mindlink.forum.models.user.userDtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;


public record LoginRequest(
        @Email
        @NotBlank
        @Getter
        String email,

        @NotBlank
        @Getter
        String password
) {}
