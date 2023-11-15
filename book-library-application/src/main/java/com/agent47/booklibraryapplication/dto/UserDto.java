package com.agent47.booklibraryapplication.dto;


import com.agent47.booklibraryapplication.entity.Role;
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
    private Integer userId;
    private String firstName;
    private String lastName;
    private String address;
    private Role role;

    // Constructors, getters, setters, and other methods can be added here.
}
