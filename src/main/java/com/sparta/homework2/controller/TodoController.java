package com.sparta.homework2.controller;

import com.sparta.homework2.repository.Todo;
import com.sparta.homework2.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TodoController {

    public final TodoService todoService;

    //TODO 일정 작성
    @PostMapping("/v1.0/todo")
    public ResponseEntity<TodoResponseDTO> postTodo(@RequestBody TodoRequestDTO dto){
        Todo todo = todoService.createTodo(dto);
        TodoResponseDTO response = new TodoResponseDTO(todo);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/v1.0/todo/{todoId}")
    public ResponseEntity<TodoResponseDTO> getTodo(@PathVariable long todoId){
        Todo todo = todoService.getTodo(todoId);
        TodoResponseDTO response = new TodoResponseDTO(todo);
        return ResponseEntity.ok().body(response);
    }
}
