package com.sparta.homework2.controller;

import com.sparta.homework2.repository.Todo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoRequestDTO {

    private String title;

    private String content;

    private String userName;

    private String password;

    public Todo toEntity(){
        return Todo.builder()
                .title(title)
                .content(content)
                .userName(userName)
                .password(password)
                .build();
    }
}
