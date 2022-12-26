package com.zookepers.zookeepers.service.member;

import java.util.List;
import java.util.Optional;

import com.zookepers.zookeepers.dto.JoinDto;
import com.zookepers.zookeepers.dto.LoginDto;
import com.zookepers.zookeepers.entity.MemberEntity;

public interface MemberService{
    
    public void join(JoinDto joinDto); 

    public MemberEntity login(LoginDto loginDto);

    public String findNickname(String MemberNo);

    public MemberEntity findMemberByMemberNo(String MemberNo);

    public String getMemberId();
}