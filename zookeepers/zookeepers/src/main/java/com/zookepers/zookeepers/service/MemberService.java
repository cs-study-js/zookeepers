package com.zookepers.zookeepers.service;

import java.util.List;
import java.util.Optional;

import com.zookepers.zookeepers.Entity.Member;

public interface MemberService{
    
    public void join(Member member); 

    public Member login(Member member);

    public String findNickname(String MemberNo);

    public Member findMemberByMemberNo(String MemberNo);

    public String getMemberId();
}