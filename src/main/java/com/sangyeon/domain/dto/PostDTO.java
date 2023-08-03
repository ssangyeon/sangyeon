package com.sangyeon.domain.dto;

import com.sangyeon.domain.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class PostDTO {
    private String postTitle;
    private String postContents;
    private String userId;

    public void updateEntity(Post post){
        post.setPostTitle(this.postTitle);
        post.setPostContents(this.postContents);
    }
}
