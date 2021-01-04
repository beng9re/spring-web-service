package com.devBangs.springboot.web.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //파이널이 들어간 생성자를 포함
public class HelloResponseDto {
    private final String name;
    private final int amount;

}
