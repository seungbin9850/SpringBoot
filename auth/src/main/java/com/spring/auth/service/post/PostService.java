package com.spring.auth.service.post;

import com.spring.auth.domain.request.PostWriteRequest;

public interface PostService {
    void write(PostWriteRequest postWriteRequest);
}
