package com.zookeepers.zookeepers.dto.member;

import java.time.LocalDateTime;

import com.zookeepers.zookeepers.entity.MemberEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequestDto {
    
    private String memberId;

    private String memberPassword;

    private String memberName;

    private String memberNickname;

    private String memberPhonenum;

    private String memberAddress;
	
    private String memberAddress2;

    private String memberDetailaddress;

    public MemberEntity toEntity(String memberNo){
        return MemberEntity.builder().
               memberNo(memberNo).
               memberId(memberId).
               memberPassword(memberPassword).
               memberName(memberName).
               memberNickname(memberNickname).
               memberPhonenum(memberPhonenum).
               memberJoindate(LocalDateTime.now()).
               memberAddress(memberAddress).
               memberDetailaddress(memberDetailaddress).
               build();
    }
}
