package com.sparta.homework2.entity;

import com.sparta.homework2.dto.CommentRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long commentId;

    @NotEmpty(message = "공백이거나 null인 것은 불가합니다.")
    private String comment;

    @Column(length = 100)
    @Email
    private Long userId;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Comment(Todo todo, CommentRequestDTO commentRequestDTO) {
        this.comment = commentRequestDTO.getComment();
        this.userId = commentRequestDTO.getUserId();
        this.createdAt = LocalDateTime.now();
        this.todo = todo;

    }

    public void updateComment(CommentRequestDTO requestDTO){
        this.comment = requestDTO.getComment();
    }

}
