package com.example.demo.client;

import com.example.demo.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "postClient",
        url = "https://jsonplaceholder.typicode.com"
)
public interface PostClient {

    @GetMapping("/posts/{id}")
    Post getPostById(@PathVariable Long id);
}