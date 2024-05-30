package com.sparta.homework2.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {
    @NotEmpty
    private String comment;
    private String userName;
}