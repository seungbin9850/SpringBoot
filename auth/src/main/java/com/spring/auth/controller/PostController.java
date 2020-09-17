package com.spring.auth.controller;

import com.spring.auth.domain.request.PostWriteRequest;
import com.spring.auth.entity.Post;
import com.spring.auth.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public void write(@RequestBody @Valid PostWriteRequest postWriteRequest) {
        postService.write(postWriteRequest);
    }

    @GetMapping
    public List<Post> show() {
        return postService.showAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}