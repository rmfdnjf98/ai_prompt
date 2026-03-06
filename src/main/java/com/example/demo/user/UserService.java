package com.example.demo.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void join(UserRequest.Join requestDTO) {
        User user = User.builder()
                .username(requestDTO.getUsername())
                .password(requestDTO.getPassword())
                .email(requestDTO.getEmail())
                .build();
        userRepository.save(user);
    }

    public Boolean isUsernameTaken(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
