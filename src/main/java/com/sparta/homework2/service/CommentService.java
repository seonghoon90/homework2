package com.sparta.homework2.service;

import com.sparta.homework2.dto.CommentRequestDTO;
import com.sparta.homework2.dto.CommentResponseDTO;
import com.sparta.homework2.entity.Comment;
import com.sparta.homework2.entity.Todo;
import com.sparta.homework2.repository.CommentRepository;
import com.sparta.homework2.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;

    public CommentResponseDTO createComment(Long todoId, CommentRequestDTO requestDTO) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new IllegalArgumentException("선택한 일정이 없습니다.")
        );

        Comment comment = new Comment(todo, requestDTO);
        commentRepository.save(comment);
        return new CommentResponseDTO(comment);
    }



}
