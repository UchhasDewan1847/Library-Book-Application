package com.agent47.booklibraryapplication.exception;

import com.agent47.booklibraryapplication.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

//    @ExceptionHandler({UserNotFoundException.class})
//    public UserDto CourseServiceExceptionHandler(Exception ex) {
//        UserDto<UserNotFoundException> apiResponse = new APIResponse<>(null, ex.getMessage());
//
//        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
//    }
//
}
