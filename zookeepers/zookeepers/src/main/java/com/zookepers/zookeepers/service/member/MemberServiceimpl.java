package com.zookepers.zookeepers.service.member;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zookepers.zookeepers.dto.member.JoinRequestDto;
import com.zookepers.zookeepers.dto.member.LoginRequestDto;
import com.zookepers.zookeepers.entity.MemberEntity;
import com.zookepers.zookeepers.repository.MemberRepository;

@Service
public class MemberServiceimpl implements MemberService {
    
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceimpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(JoinRequestDto joinDto){
        MemberEntity memberEntity = joinDto.toEntity(memberRepository.getIdFromSeq());
                
        memberRepository.save(memberEntity);  
    }

    @Override
    public MemberEntity login(LoginRequestDto loginDto) {

        return memberRepository.findByMemberId(loginDto.getMemberId()).filter(m->loginDto.getMemberPassword().equals(m.getMemberPassword())).orElse(null);      //로그인 로직
                                                                                                                                                                      // ID값으로 멤버 찾은 후 비밀번호 비교 후 맞으면 ENTITY 리턴 틀리면 NULL리턴
    }

    @Override
    public String getMemberId() {

        return memberRepository.getIdFromSeq();                                     //멤버 시퀀스 리턴
    }

    @Override
    public String findNickname(String memberNo) {

        return memberRepository.findByMemberNo(memberNo).getMemberNickname();       //멤버 닉네임 리턴
    }

    @Override
    public MemberEntity findMemberByMemberNo(String memberNo) {                     //멤버 시퀀스로 멤버찾기

        return memberRepository.findByMemberNo(memberNo);
    }

}
