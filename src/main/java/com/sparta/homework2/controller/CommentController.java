package com.sparta.homework2.controller;

import com.sparta.homework2.dto.CommentRequestDTO;
import com.sparta.homework2.dto.CommentResponseDTO;
import com.sparta.homework2.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1.0/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{todoId}")
    public CommentResponseDTO createComment(@PathVariable Long todoId, @RequestBody @Valid CommentRequestDTO requestDTO){

        return commentService.createComment(todoId, requestDTO);
    }


}
