package com.zookepers.zookeepers.service.member;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zookepers.zookeepers.dto.JoinDto;
import com.zookepers.zookeepers.dto.LoginDto;
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
    public void join(JoinDto joinDto){
        MemberEntity memberEntity = 
        MemberEntity.builder().memberNo(memberRepository.getIdFromSeq()).
                memberId(joinDto.getMemberId()).
                memberPassword(joinDto.getMemberPassword()).
                memberName(joinDto.getMemberName()).
                memberNickname(joinDto.getMemberNickname()).
                memberPhonenum(joinDto.getMemberPhonenum()).
                memberJoindate(LocalDateTime.now()).
                memberAddress(joinDto.getDummyAddress()).
                memberDetailaddress(joinDto.getMemberDetailaddress()).
                build();
                
        memberRepository.save(memberEntity);  
    }

    @Override
    public MemberEntity login(LoginDto loginDto) {

        return memberRepository.findByMemberId(loginDto.getMemberId()).filter(m->loginDto.getMemberPassword().equals(m.getMemberPassword())).orElse(null);
    }

    @Override
    public String getMemberId() {

        return memberRepository.getIdFromSeq();
    }

    @Override
    public String findNickname(String memberNo) {

        return memberRepository.findByMemberNo(memberNo).getMemberNickname();
    }

    @Override
    public MemberEntity findMemberByMemberNo(String memberNo) {

        return memberRepository.findByMemberNo(memberNo);
    }
   

}
