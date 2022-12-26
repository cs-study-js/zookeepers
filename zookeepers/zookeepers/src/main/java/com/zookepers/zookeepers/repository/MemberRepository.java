package com.zookepers.zookeepers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zookepers.zookeepers.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String>{
    public MemberEntity save(MemberEntity member);

    public Optional<MemberEntity> findByMemberId(String member_id);

    public MemberEntity findByMemberNo(String member_no);

    @Query(value = "SELECT fn_seq('ZM')", nativeQuery = true)
    String getIdFromSeq();
} 