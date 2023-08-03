package com.sangyeon.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder//빌더패턴
@Getter
@Setter
@Table
public class Post {
    @Id
    @GeneratedValue
    private long seq;

    @Setter
    @Column(nullable = false)
    private String postTitle;

    @Setter
    @Column(nullable = false)
    private String postContents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
}
