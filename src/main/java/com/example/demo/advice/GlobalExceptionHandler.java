package com.example.demo.advice;

import com.example.demo.dto.ErrorResponseDto;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponseDto handleProductNotFound(ProductNotFoundException exception) {
        return new ErrorResponseDto(
                exception.getMessage(),
                404,
                LocalDateTime.now()
        );
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponseDto handleUserNotFound(UserNotFoundException exception) {
        return new ErrorResponseDto(
                exception.getMessage(),
                404,
                LocalDateTime.now()
        );
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponseDto handleGeneralException(Exception exception) {
        return new ErrorResponseDto(
                "internal server error",
                500,
                LocalDateTime.now()
        );
    }
}
