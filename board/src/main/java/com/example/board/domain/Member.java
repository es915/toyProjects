package com.example.board.domain;

import com.example.board.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String aka;
    @Column(nullable = false)
    private String login_id;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "Member")
    private List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "Member")
    private List<Comment> comments = new ArrayList<>();

}
