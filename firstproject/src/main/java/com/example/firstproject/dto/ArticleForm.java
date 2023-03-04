package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private String title;
    private String content;
    // new.mustache로 부터 데이터 전달받아 저장하는 dto 객체
//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
    // AllArgs를 통해 리팩토링
//    @Override
//    public String toString() {      //form형태의 값을 전달
//        return "ArticleForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
    // ToString을 통해 리팩토링
    public Article toEntity() {
        return new Article(null, title, content);
    }
}
