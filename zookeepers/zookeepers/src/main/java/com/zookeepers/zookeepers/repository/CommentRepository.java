package com.zookeepers.zookeepers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zookeepers.zookeepers.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, String>{
    public CommentEntity save(CommentEntity comment);

    public List<CommentEntity> findByBoardNo(String boardNo);
    
    @Query(value = "SELECT fn_seq('ZCM')", nativeQuery = true)
    String getIdFromSeq(); 
}
