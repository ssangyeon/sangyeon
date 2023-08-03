package com.sangyeon.domain.controller;

import com.sangyeon.domain.dto.PostDTO;
import com.sangyeon.domain.entity.User;
import com.sangyeon.domain.service.PostService;
import com.sangyeon.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody PostDTO postDTO){
        log.info("title = {}, contents = {}, userId = {}", postDTO.getPostTitle(),
                postDTO.getPostContents(), postDTO.getUserId());
        Optional<User> user = userService.getUserFromUserId(postDTO.getUserId());
        if(postService.register(postDTO, user.get()).equals("Success")){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity postList(){
        return ResponseEntity.ok().body(postService.getAllPosts());
    }

    @PatchMapping("/{postId}")
    public ResponseEntity postUpdate(@PathVariable Long postId, @RequestBody PostDTO postDTO){
        log.info("postId = {}", postId);
        log.info("update title = {}, update contents = {}", postDTO.getPostTitle(),
                postDTO.getPostContents());
        if(postService.postUpdate(postId, postDTO).equals("Success")){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity postDelete(@PathVariable Long postId){
        log.info("postId = {}", postId);
        if(postService.postDelete(postId).equals("Success")){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
