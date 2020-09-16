package com.spring.auth.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PostWriteRequest {
    @NotNull
    private String title;

    @NotNull
    private String content;
}
