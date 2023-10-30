package com.agent47.booklibraryapplication.service;

import com.agent47.booklibraryapplication.dto.UserDto;
import com.agent47.booklibraryapplication.entity.BookUser;
import com.agent47.booklibraryapplication.repository.BookRepository;
import com.agent47.booklibraryapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private final UserRepository userRepository;
    private BookUser bookUser;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(BookUser bookUser) {
        userRepository.save(bookUser);
        return "User Saved";
    }

    @Override
    public String loginUser(String email, String password) {
        if(Objects.nonNull(email)&& Objects.nonNull(password))
        {
            bookUser = userRepository.findByEmail(email);
        }
        if(Objects.isNull(bookUser)){
            return "User Not found";
        }
        if(!bookUser.getPassword().equals(password)) {
            return "Password is incorrect";
        }
        return bookUser.getUserId().toString();
    }

    @Override
    public UserDto getUserInfo(UUID userUuid) {

//        bookUser = userRepository.findById(userUuid).get();
//
//
//
//        return new UserDto(
//                bookUser.getUserId(),
//                bookUser.getFirstName(),
//                bookUser.getLastName(),
//                bookUser.getAddress(),
//                bookUser.getRole()
//        );

        Optional<BookUser> userOptional = userRepository.findById(userUuid);

        if (userOptional.isPresent()) {
            BookUser bookUser = userOptional.get();
            return new UserDto(
                    bookUser.getUserId(),
                    bookUser.getFirstName(),
                    bookUser.getLastName(),
                    bookUser.getAddress(),
                    bookUser.getRole()
            );
        } else {
            //throw new Exception("User not found with ID: " + userUuid);

            return new UserDto();

        }
    }
}
