package com.sangyeon.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PostListResponse {
    private Long postId;
    private String postTitle;
    private String postContents;
    private String userName;
}
