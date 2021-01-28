package com.devBangs.springboot.config.auth.Dto;

import com.devBangs.springboot.web.domain.User.Role;
import com.devBangs.springboot.web.domain.User.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {

    private Map<String,Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String,Object> attributes,
            String nameAttributeKey,
            String name,
            String email,
            String picture){

        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture =picture;
    }

    //메을 바인딩 해줌
    public static OAuthAttributes of(String registrationId,
                                     String userNameAtrributeName,
                                     Map<String,Object> attributes){
        if("naver".equals(registrationId)){
            return ofNaver("id",attributes);
        }

        return ofGoogle(userNameAtrributeName,attributes);
    }
    private static OAuthAttributes ofNaver(String userNameAtrributeName,Map<String,Object> attributes){
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .picture((String) response.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAtrributeName)
                .build();

    }

    public static OAuthAttributes ofGoogle(String userNameAtrributeName,Map<String,Object> attributes){
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAtrributeName)
                .build();
    }


    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }


}
