package com.devBangs.springboot.config.auth;

import com.devBangs.springboot.web.domain.User.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;

@RequiredArgsConstructor
@EnableWebSecurity //스프링시큐리티 설정 활성화
public class SequrityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOauth2UserService customOauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console활성
                .and()
                    //URL별 권한활성화
                    .authorizeRequests()
                    //권한설정범위
                    .antMatchers("/","/css/**","images/**","/js/**","/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasAnyRole(Role.USER.name())
                    //전체리퀘스트
                    .anyRequest().authenticated()
                .and()
                    //로그아웃 URL
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    //오어스 로그인
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOauth2UserService);

    }
}
