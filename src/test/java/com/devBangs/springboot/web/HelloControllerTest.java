package com.devBangs.springboot.web;


import com.devBangs.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

//스프링 부트 와 JUnit 연결자
@RunWith(SpringRunner.class)
//컨트롤러 테스트할때이용
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = SecurityConfig.class) //테스트는 @controller,... 등 스캔 대상이 아니라
        //config 오류 발생
})
public class HelloControllerTest {
    //웹 API 테스트용
    @Autowired
    private MockMvc mvc;


    @Test
    @WithMockUser(roles = "USER")   //유저권한실행
    public void hello가_리턴() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    @WithMockUser(roles = "USER")   //유저권한실행
    public void hellotDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount))) //값은 스트링으로만옴
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) //$.변수로 검증한다
                .andExpect(jsonPath("$.amount",is(amount)));
    }

}
