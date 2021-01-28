package com.devBangs.springboot.web;

import com.devBangs.springboot.config.auth.Dto.SessionUser;
import com.devBangs.springboot.config.auth.LoginUser;
import com.devBangs.springboot.service.posts.PostsService;
import com.devBangs.springboot.web.Dto.PostsResponseDto;
import com.devBangs.springboot.web.domain.Posts;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.AbstractAuditable_;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findAlldesc());
        //세션
        if (user != null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id,Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
