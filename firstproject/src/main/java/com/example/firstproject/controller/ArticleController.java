package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j              // 로깅을 위한 어노테이션 @
public class ArticleController {
    @Autowired      // spring boot가 미리 생성해놓은 객체를 자동 연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")                    // post METHOD로 전달받은 DTO 객체의 내용을
    public String createArticle(ArticleForm form){      // form이라는 변수로 전달받음
        // System.out.println(form.toString());
        // 로깅으로 대체하기
        log.info(form.toString());

        // 데이터를 DB에 저장
        // 1. DTO -> Entitiy
        Article article = form.toEntity();
        // System.out.println(article.toString());         // println() -> 로그 남기기 with Lombok
        log.info(article.toString());

        // 2. Repository를 통해 Entity를 DB에 전달
        Article saved = articleRepository.save(article);
        // System.out.println(saved.toString());           // DB에 저장
        log.info(saved.toString());

        return "";
    }

}
