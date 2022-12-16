package com.zookepers.zookeepers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zookepers.zookeepers.Entity.Member;
import com.zookepers.zookeepers.repository.MemberRepository;

@Service
public class MemberServiceimpl implements MemberService {
    
    final MemberRepository memberRepository;

    @Autowired
    public MemberServiceimpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member){
        
        memberRepository.save(member);  
    }

    @Override
    public Member login(Member member) {
        return memberRepository.findByMemberid(member.getMember_id()).filter(m->m.getMember_password().equals(member.getMember_password())).orElse(null);
    }

    @Override
    public String getMemberId() {
        return memberRepository.getIdFromSeq();
    }

    @Override
    public String findNickname(String MemberNo) {

        return memberRepository.findByMemberno(MemberNo).getMember_nickname();
    }

    @Override
    public Member findMemberByMemberNo(String MemberNo) {
        return memberRepository.findByMemberno(MemberNo);
    }
   

}
