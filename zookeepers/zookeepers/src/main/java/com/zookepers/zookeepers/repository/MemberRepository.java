package com.zookepers.zookeepers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zookepers.zookeepers.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
    public Member save(Member member);

    // Optional<Member> findByMemberId(String member_id);
} 