package com.agent47.booklibraryapplication.controller;

import com.agent47.booklibraryapplication.dto.UserDto;
//import com.agent47.booklibraryapplication.entity.BookUser;
//import com.agent47.booklibraryapplication.service.BookServiceImpl;
import com.agent47.booklibraryapplication.service.UserServiceImpl;
//import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//import java.util.UUID;

@RestController
@RequestMapping("/auth/book_management")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
//    @Autowired
//    private BookServiceImpl bookServiceImpl;
//    @PostMapping("/user/register")
//    public String registerUser(@Valid @RequestBody BookUser bookUser){
//        bookServiceImpl.addBooks(bookUser.getBooks());
//        return userServiceImpl.registerUser(bookUser);
//    }
//    @PostMapping("/user/login")
//    public String loginUser(@Valid @RequestBody Map<String, String> data) {
//        String email = data.get("email");
//        String password = data.get("password");
//        return userServiceImpl.loginUser(email, password);
//    }

    @GetMapping("/user/info/{id}")
    public UserDto getUserInfo(@PathVariable("id") Integer user_id){
        return userServiceImpl.getUserInfo(user_id);
    }

}
