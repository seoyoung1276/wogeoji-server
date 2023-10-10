package com.example.kotlinprojectserver.service;

import com.example.kotlinprojectserver.dto.AddArticleRequest;
import com.example.kotlinprojectserver.entity.Article;
import com.example.kotlinprojectserver.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class BlogService {

    private final BlogRepository blogRepository;


    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}


