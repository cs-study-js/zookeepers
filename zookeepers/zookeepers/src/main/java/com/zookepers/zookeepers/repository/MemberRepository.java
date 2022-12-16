package com.zookepers.zookeepers.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zookepers.zookeepers.Entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
    public Member save(Member member);

    public Optional<Member> findByMemberid(String member_id);

    public Member findByMemberno(String member_no);

    @Query(value = "SELECT fn_seq('ZM')", nativeQuery = true)
    String getIdFromSeq();
} 