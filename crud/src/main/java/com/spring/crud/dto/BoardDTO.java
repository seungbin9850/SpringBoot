package com.spring.crud.dto;

import com.spring.crud.domain.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime regDateTime;
    private String regUserId;
    private LocalDateTime editDateTime;
    private String editUserId;

    public Board toEntity() {
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .regUserId(regUserId)
                .editUserId(editUserId)
                .build();
    }

    public BoardDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.regDateTime = board.getRegDateTime();
        this.regUserId = board.getRegUserId();
        this.editDateTime = board.getEditDateTime();
        this.editUserId = board.getEditUserId();
    }
}