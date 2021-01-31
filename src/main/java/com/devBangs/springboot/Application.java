package com.devBangs.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing //Audit 기능 활성화
@SpringBootApplication //메인 클래스
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
