package com.example.kotlinprojectserver.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.ErrorResponse;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // 'title' 이라는 not null 컬럼과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    private Integer cost;

    @ManyToOne
    private Member author; // 게시물을 작성한 회원

    @ManyToOne
    private Group group; // 게시물이 속한 그룹

    @OneToMany(mappedBy = "article")
    private List<Comment> comments;


    @Builder
    public Article(String title, String content, Integer cost, Member author, Group group, List<Comment> comments){
        this.title = title;
        this.content = content;
        this.cost = cost;
        this.author = author;
        this.group = group;
        this.comments = comments;
    }





}
