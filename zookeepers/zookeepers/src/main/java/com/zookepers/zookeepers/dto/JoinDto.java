package com.zookepers.zookeepers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDto {
    
    private String memberId;

    private String memberPassword;

    private String memberName;

    private String memberNickname;

    private String memberPhonenum;

    private String dummyAddress;
	
    private String dummyAddress2;

    private String memberDetailaddress;
}
