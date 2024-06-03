package com.sparta.homework2.controller;

import com.sparta.homework2.dto.TodoRequestDTO;
import com.sparta.homework2.dto.TodoResponseDTO;
import com.sparta.homework2.entity.Todo;
import com.sparta.homework2.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/todo")
@RestController
@AllArgsConstructor
public class TodoController {

    public final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDTO> postTodo(@RequestBody TodoRequestDTO dto) {
        Todo todo = todoService.createTodo(dto);
        TodoResponseDTO response = new TodoResponseDTO(todo);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoResponseDTO> getTodo(@PathVariable long todoId) {
        Todo todo = todoService.getTodo(todoId);
        TodoResponseDTO response = new TodoResponseDTO(todo);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDTO>> getTodos() {
        List<Todo> todos = todoService.getTodos();
        List<TodoResponseDTO> response = todos.stream()
                .map(TodoResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<TodoResponseDTO> putTodo(@PathVariable long todoId, @RequestBody TodoRequestDTO dto) {
        Todo todo = todoService.updateTodo(todoId,dto);
        TodoResponseDTO response = new TodoResponseDTO(todo);
        return ResponseEntity.ok().body(response);

    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long todoId, @RequestBody TodoRequestDTO dto) {
        todoService.deleteTodo(todoId, dto.getPassword());
        return ResponseEntity.ok().build();
    }
}
