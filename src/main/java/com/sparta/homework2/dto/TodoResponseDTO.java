package com.sparta.homework2.dto;

import com.sparta.homework2.entity.Todo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoResponseDTO {

    private Long todoId;

    private String title;

    private String content;

    private String userName;

    private LocalDateTime createdAt;

    public TodoResponseDTO(Todo todo){
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.userName = todo.getUserName();
        this.createdAt = todo.getCreatedAt();
    }
}