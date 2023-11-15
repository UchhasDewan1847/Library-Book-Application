package com.agent47.booklibraryapplication.service;

import com.agent47.booklibraryapplication.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService {
    String loginUser(String email, String password);

    UserDto getUserInfo(Integer userUuid);
}
