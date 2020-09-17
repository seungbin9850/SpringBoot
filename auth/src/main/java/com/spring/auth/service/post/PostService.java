package com.spring.auth.service.post;

import com.spring.auth.domain.request.PostWriteRequest;
import com.spring.auth.entity.Post;

import java.util.List;

public interface PostService {
    void write(PostWriteRequest postWriteRequest);
    void delete(Long id);
    List<Post> showAll();
}
