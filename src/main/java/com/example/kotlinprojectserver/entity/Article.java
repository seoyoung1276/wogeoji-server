package com.example.kotlinprojectserver.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.ErrorResponse;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    // TODO: 게시물을 쓴 member의 아이디 연관관계 매핑
    // TODO: 게시물이 속한 그룹의 아이디 연관관계 매핑
    // Spring ManyToOne 이나 OneToMany 검색하면 많이 나오고 내가 만든 entity에도 있음

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // 'title' 이라는 not null 컬럼과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }


}
