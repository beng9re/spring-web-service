package com.devBangs.springboot.web.Dto;

import com.devBangs.springboot.web.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String content;
    private String author;
    private String title;

    @Builder
    public PostsSaveRequestDto(String content, String author,String title){
        this.content = content;
        this.author = author;
        this.title = title;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }


}
