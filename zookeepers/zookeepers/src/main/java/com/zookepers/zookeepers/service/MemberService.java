package com.zookepers.zookeepers.service;

import com.zookepers.zookeepers.domain.Member;

public interface MemberService{
    
    public void join(Member member);

    public Member login(Member member);
}