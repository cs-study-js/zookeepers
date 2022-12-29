package com.zookeepers.zookeepers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zookeepers.zookeepers.entity.TradeCommentEntity;

public interface TradeCommentRepository extends JpaRepository <TradeCommentEntity, String> {
    public TradeCommentEntity save(TradeCommentEntity comment);

    public List<TradeCommentEntity> findByTradeBoardNo(String tradeBoardNo);
    
    @Query(value = "SELECT fn_seq('TCM')", nativeQuery = true)
    String getIdFromSeq(); 
}
