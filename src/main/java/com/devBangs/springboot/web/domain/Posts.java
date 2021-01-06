package com.devBangs.springboot.web.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //고본생성자 자동추가
@Entity //테이블링크 클래스 기본값 카멜케이스 => 언더스코어 으로 자동 맵핑
public class Posts {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment
    private Long id;

    @Column(length = 500,nullable = false) //길이 VARCHAR(255)가 기본값
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title,String content,String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title,String content){
        this.title = title;
        this.content = content;
    }


}
