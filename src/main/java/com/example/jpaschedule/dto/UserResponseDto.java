package com.example.jpaschedule.dto;

import lombok.Getter;

@Getter
public class UserResponseDto {
    private final Long id;
    private final String name;
    private final String email;

    public UserResponseDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
