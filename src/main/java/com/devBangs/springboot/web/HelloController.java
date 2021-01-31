package com.devBangs.springboot.web;

import com.devBangs.springboot.web.Dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping()
    public String hello(){
        HelloResponseDto dto = new HelloResponseDto("String",100);
        return "hello";

    }

    @GetMapping("/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){

        return new HelloResponseDto(name,amount);
    }

}
