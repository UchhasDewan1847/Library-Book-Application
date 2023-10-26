package com.agent47.booklibraryapplication.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String address;
    private String role;

    // Constructors, getters, setters, and other methods can be added here.
}
