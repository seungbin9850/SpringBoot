package com.spring.auth.service.post;

import com.spring.auth.domain.request.PostWriteRequest;
import com.spring.auth.entity.Post;
import com.spring.auth.entity.repository.PostRepository;
import com.spring.auth.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public void write(PostWriteRequest postWriteRequest) {
        String title = postWriteRequest.getTitle();
        String content = postWriteRequest.getContent();
        String email = authenticationFacade.getUserEmail();

        postRepository.save(
            Post.builder()
                .title(title)
                .content(content)
                .email(email)
                .build()
        );
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> showAll() {
        return postRepository.findAll();
    }
}
