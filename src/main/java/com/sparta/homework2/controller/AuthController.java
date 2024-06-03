package com.sparta.homework2.controller;

import com.sparta.homework2.dto.AuthRequest;
import com.sparta.homework2.until.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/authenticate")
    public String createToken(@RequestBody AuthRequest authRequest) throws Exception {
        if ("user".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
            return JwtTokenProvider.generateToken(authRequest.getUsername());
        } else {
            throw new Exception("유효하지 않은 자격증명");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestHeader("Authorization") String token) {
        String username = JwtTokenProvider.extractUsername(token.substring(7));
        if (JwtTokenProvider.validateToken(token.substring(7), username)) {
            return "유효한 토근";
        } else {
            return "유효하지 않은 토근";
        }
    }

    //API -> 토근을 발급, 토큰을 검증(유효, 유효하지 않다.)
}
