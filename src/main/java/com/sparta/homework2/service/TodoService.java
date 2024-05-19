package com.sparta.homework2.service;

import com.sparta.homework2.controller.TodoRequestDTO;
import com.sparta.homework2.repository.Todo;
import com.sparta.homework2.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    //할일 생성
    public Todo createTodo(TodoRequestDTO dto) {
        var newTodo = dto.toEntity();
        return todoRepository.save(newTodo);
    }
}
