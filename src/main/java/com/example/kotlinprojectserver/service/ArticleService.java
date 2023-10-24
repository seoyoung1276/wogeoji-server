package com.example.kotlinprojectserver.service;

import com.example.kotlinprojectserver.entity.Article;
import com.example.kotlinprojectserver.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

}
