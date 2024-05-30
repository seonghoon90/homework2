package com.sparta.homework2.dto;

import com.sparta.homework2.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDTO {
    private String userName;
    private String comment;
    private LocalDateTime createdAt;

    public CommentResponseDTO(Comment comment) {
        this.userName = comment.getUserName();
        this.comment = comment.getComment();
        this.createdAt = comment.getCreatedAt();
    }
}
