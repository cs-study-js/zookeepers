package com.zookeepers.zookeepers.service.member;

import java.util.List;
import java.util.Optional;

import com.zookeepers.zookeepers.dto.member.JoinRequestDto;
import com.zookeepers.zookeepers.dto.member.LoginRequestDto;
import com.zookeepers.zookeepers.entity.MemberEntity;

public interface MemberService{
    
    public void join(JoinRequestDto joinDto); 

    public MemberEntity login(LoginRequestDto loginDto);

    public String findNickname(String MemberNo);

    public MemberEntity findMemberByMemberNo(String MemberNo);

    public String getMemberId();
}