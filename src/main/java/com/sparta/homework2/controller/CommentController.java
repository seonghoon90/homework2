package com.sparta.homework2.controller;

import com.sparta.homework2.dto.CommentRequestDTO;
import com.sparta.homework2.dto.CommentResponseDTO;
import com.sparta.homework2.entity.Comment;
import com.sparta.homework2.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{todoId}")
    public CommentResponseDTO createComment(@PathVariable Long todoId, @RequestBody @Valid CommentRequestDTO requestDTO){

        return commentService.createComment(todoId, requestDTO);
    }
    @PutMapping("/comment/{todoId}/{commentId}")
    public CommentResponseDTO updateComment(@PathVariable Long todoId, @PathVariable Long commentId, @RequestBody CommentRequestDTO requestDTO){

        return commentService.updateComment(todoId, commentId, requestDTO);
    }

    @DeleteMapping("/comment/{todoId}/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long todoId, @PathVariable Long commentId, @RequestHeader Long userId) {

        commentService.deleteComment(todoId, commentId, userId);
        return new ResponseEntity<>("댓글 삭제 성공했습니다.", HttpStatusCode.valueOf(201));
    }

}
