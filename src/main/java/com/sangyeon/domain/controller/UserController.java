package com.sangyeon.domain.controller;

import com.sangyeon.domain.dto.UserDTO;
import com.sangyeon.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserDTO userDTO){
        log.info("userId = {}, password = {}, userName = {}", userDTO.getUserId(),
                 userDTO.getPassword(), userDTO.getUserName());
        if(userService.signup(userDTO).equals("Success")){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO){
        log.info("userId = {}, password = {}", userDTO.getUserId(), userDTO.getPassword());
        if(userService.login(userDTO.getUserId(),userDTO.getPassword()).equals("Success")){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
