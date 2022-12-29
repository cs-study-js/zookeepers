package com.zookeepers.zookeepers.dto.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    private String memberId;

    private String memberPassword;

}