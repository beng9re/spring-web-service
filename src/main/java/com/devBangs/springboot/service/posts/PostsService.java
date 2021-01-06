package com.devBangs.springboot.service.posts;

import com.devBangs.springboot.web.Dto.PostsResponseDto;
import com.devBangs.springboot.web.Dto.PostsSaveRequestDto;
import com.devBangs.springboot.web.Dto.PostsUpdateRequestDto;
import com.devBangs.springboot.web.domain.Posts;
import com.devBangs.springboot.web.domain.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당게시글 없다. id=" + id));
        //JPA 영속성 컨텍스트라 업데이트 하지않음
        posts.update(requestDto.getTitle(),requestDto.getContent());


        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다 id="+id));
        return new PostsResponseDto(entity);
    }

}
