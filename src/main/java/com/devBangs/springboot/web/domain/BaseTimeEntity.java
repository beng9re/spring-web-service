package com.devBangs.springboot.web.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA 엔티티 클래스 BaseTimeEntity 상속시 필드를 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate //시간 자동저장
    private LocalDateTime CreatedDate;

    @LastModifiedDate // 변경할 때 자동저장
    private LocalDateTime modifiedDate;

}
