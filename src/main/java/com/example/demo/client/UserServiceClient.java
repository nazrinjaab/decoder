package com.example.demo.client;

import com.example.demo.config.UserServiceErrorDecoder;
import com.example.demo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "userServiceClient",
        url = "http://localhost:8080",
        configuration = UserServiceErrorDecoder.class

)
public interface UserServiceClient {

    @GetMapping("/api/users/{id}")
    User getUserById(@PathVariable Long id);
}