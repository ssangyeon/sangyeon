package com.sangyeon.domain.service;

import com.sangyeon.domain.dto.PostDTO;
import com.sangyeon.domain.dto.PostListResponse;
import com.sangyeon.domain.entity.Post;
import com.sangyeon.domain.entity.User;
import com.sangyeon.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;


    public String register(PostDTO postDTO, User user){
        postRepository.save(Post.builder()
                .postTitle(postDTO.getPostTitle())
                .postContents(postDTO.getPostContents())
                .user(user)
                .build());
        return "Success";
    }

    public List<PostListResponse> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostListResponse> postList = new ArrayList<>();

        for (Post p : posts) {
            PostListResponse post = new PostListResponse();
            post.setPostId(p.getSeq());
            post.setPostTitle(p.getPostTitle());
            post.setPostContents(p.getPostContents());
            post.setUserName(p.getUser().getUserName());
            postList.add(post);
        }
        return postList;
    }

    public String postUpdate(Long postId, PostDTO postDTO) {
        Optional<Post> post = postRepository.findById(postId);
        postDTO.updateEntity(post.get());
        postRepository.save(post.get());
        return "Success";
    }

    public String postDelete(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        postRepository.delete(post.get());
        return "Success";
    }
}
