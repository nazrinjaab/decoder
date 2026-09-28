package com.example.demo.controller;

import com.example.demo.client.PostClient;
import com.example.demo.model.Post;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostClient postClient;

    public PostController(PostClient postClient) {
        this.postClient = postClient;
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postClient.getPostById(id);
    }
}