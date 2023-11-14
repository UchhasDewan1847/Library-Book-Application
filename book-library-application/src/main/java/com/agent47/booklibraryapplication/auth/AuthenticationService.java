package com.agent47.booklibraryapplication.auth;

import com.agent47.booklibraryapplication.entity.BookUser;
import com.agent47.booklibraryapplication.entity.Role;
import com.agent47.booklibraryapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    public boolean register(RegisterRequest registerRequest) {
        BookUser user= BookUser.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .address(registerRequest.getAddress())
                .password(registerRequest.getPassword())
                .role(Role.USER)
                .build();
        var u =userRepository.save(user);
        if(u!= null)
            return true;
        else
            return false;

    }
}
