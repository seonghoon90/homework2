package com.sparta.homework2.service;

import com.sparta.homework2.dto.CommentRequestDTO;
import com.sparta.homework2.dto.CommentResponseDTO;
import com.sparta.homework2.entity.Comment;
import com.sparta.homework2.entity.Todo;
import com.sparta.homework2.repository.CommentRepository;
import com.sparta.homework2.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

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


    @Transactional
    public CommentResponseDTO updateComment(Long todoId,Long commentId, CommentRequestDTO requestDTO) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new IllegalArgumentException("선택한 일정이 없습니다.")
        );

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("조회한 댓글이 없습니다.")
        );

        if(comment.getUserId().equals(requestDTO.getUserId())){
            comment.updateComment(requestDTO);
        } else {
            throw new IllegalArgumentException("사용자 ID가 일치하지 않습니다.");

        }
        return new CommentResponseDTO(comment);
    }

    public void deleteComment(Long todoId, Long commentId, Long userId) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new IllegalArgumentException("선택한 일정이 없습니다.")
        );
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("조회한 댓글이 없습니다.")
        );

        if (comment.getUserId().equals(userId)) {
            commentRepository.delete(comment);
        } else {
            throw new IllegalArgumentException("사용자 ID가 일치하지 않습니다.");

        }

    }
}
