package com.zookepers.zookeepers.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zookepers.zookeepers.repository.MemberRepository;
import com.zookepers.zookeepers.domain.Member;

@Service
public class MemberServiceimpl implements MemberService {
    
    final MemberRepository Repository;

    @Autowired
    public MemberServiceimpl(MemberRepository memberRepository){
        this.Repository = memberRepository;
    }

    @Override
    public void join(Member member){
        Repository.save(member);  
    }

    @Override
    public Member login(Member member) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
