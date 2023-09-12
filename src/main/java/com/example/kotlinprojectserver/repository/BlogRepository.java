package com.example.kotlinprojectserver.repository;

import com.example.kotlinprojectserver.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
