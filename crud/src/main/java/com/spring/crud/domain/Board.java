package com.spring.crud.domain;

import lombok.*;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@ToString
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime regDateTime;

    @Column(nullable = false)
    private String regUserId;

    @UpdateTimestamp
    private LocalDateTime editDateTime;

    @Column
    private String editUserId;

    @Builder
    private Board(Long id, String title, String content, String regUserId, String editUserId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.regUserId = regUserId;
        this.editUserId = editUserId;
    }
}