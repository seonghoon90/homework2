package com.sparta.homework2.service;

import com.sparta.homework2.dto.RegisterRequest;
import com.sparta.homework2.entity.User;
import com.sparta.homework2.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void register(RegisterRequest registerRequest) throws Exception {
        User user = new User();
        user.setUserInfo(
                registerRequest.getUsername(),
                registerRequest.getPassword()
        ); // 원래라면 encode를 해서 넣어야 함

        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new Exception("이미 중복된 사용자 이름입니다.");
        }
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null || !Objects.equals(user.getPassword(), password)) {
            throw new IllegalArgumentException("유효하지 않은 사용자 이름 혹은 잘못된 비밀번호");
        }
        return user;
    }
}
