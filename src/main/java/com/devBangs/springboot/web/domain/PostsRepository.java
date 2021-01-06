package com.devBangs.springboot.web.domain;

import org.springframework.data.jpa.repository.JpaRepository;


//JPA <모델,PK> 상속
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
