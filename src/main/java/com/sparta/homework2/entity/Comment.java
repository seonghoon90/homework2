package com.sparta.homework2.entity;

import com.sparta.homework2.dto.CommentRequestDTO;
import com.sparta.homework2.dto.CommentResponseDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

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
    private String comment;
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
