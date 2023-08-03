package com.sangyeon.domain.service;

import com.sangyeon.domain.dto.PostDTO;
import com.sangyeon.domain.dto.PostListResponse;
import com.sangyeon.domain.dto.UserDTO;
import com.sangyeon.domain.entity.Post;
import com.sangyeon.domain.entity.User;
import com.sangyeon.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public String signup(UserDTO userDTO){
        userRepository.save(User.builder()
                .userId(userDTO.getUserId())
                .password(userDTO.getPassword())
                .userName(userDTO.getUserName())
                .build());
        return "Success";

    }

    public String login(String userId, String password) {
        Optional<User> user = userRepository.findByUserId(userId);
        log.info("db password = {}, input password = {}", user.get().getPassword(),password);
        if(user.get().getPassword().equals(password)){
            return "Success";
        }
        return "Failed";
    }

    public Optional<User> getUserFromUserId(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        return user;
    }
}
