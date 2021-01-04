package com.devBangs.springboot.web;

import com.devBangs.springboot.web.Dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        HelloResponseDto dto = new HelloResponseDto("String",100);
        return "hello";

    }
}
