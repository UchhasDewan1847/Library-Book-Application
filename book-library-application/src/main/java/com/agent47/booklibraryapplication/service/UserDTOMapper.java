package com.agent47.booklibraryapplication.service;

import com.agent47.booklibraryapplication.dto.UserDto;
import com.agent47.booklibraryapplication.entity.BookUser;
import org.apache.el.stream.Stream;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class UserDTOMapper implements Function<BookUser, UserDto> {
    @Override
    public UserDto apply(BookUser bookUser) {
        return new UserDto(
                bookUser.getUserId(),
                bookUser.getFirstName(),
                bookUser.getLastName(),
                bookUser.getAddress(),
                bookUser.getRole()
        );
    }
}
