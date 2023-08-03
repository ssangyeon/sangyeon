package com.sangyeon.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder//빌더패턴
@Getter
@Table
public class User {
    @Id
    @GeneratedValue
    private long seq;

    @Column(unique = true)
    private String userId;

    @Column(unique = true)
    private String password;

    @Column(unique = true)
    private String userName;

}
