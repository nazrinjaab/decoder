package com.example.demo.config;

import com.example.demo.exception.InvalidRequestException;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.exception.UserNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UserServiceErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        String responseBody = "";

        try {
            if (response.body() != null) {
                responseBody = new String(
                        response.body().asInputStream().readAllBytes(),
                        StandardCharsets.UTF_8
                );
            }
        } catch (IOException exception) {
            responseBody = "cant read response body";
        }

        if (response.status() == 400) {
            return new InvalidRequestException(
                    "Invalid request:" + responseBody
            );
        }

        if (response.status() == 401) {
            return new UnauthorizedException(
                    "Unauthorized:" + responseBody
            );
        }

        if (response.status() == 404) {
            return new UserNotFoundException(
                    "user not found:" + responseBody
            );
        }

        return new ErrorDecoder.Default().decode(methodKey, response);
    }
}