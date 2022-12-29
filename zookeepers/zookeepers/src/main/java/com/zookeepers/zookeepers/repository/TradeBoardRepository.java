package com.zookeepers.zookeepers.repository;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zookeepers.zookeepers.entity.TradeBoardEntity;

public interface TradeBoardRepository extends JpaRepository <TradeBoardEntity, String>{
    public TradeBoardEntity save(TradeBoardEntity tradeBoardEntity);
    
    public List<TradeBoardEntity> findAll();

    public List<TradeBoardEntity> findByTradeBoardTitle(String tradeBoardTitle);

    public List<TradeBoardEntity> findByTradeBoardCategory(String tradeBoardCategory);

    public TradeBoardEntity findByTradeBoardNo(String tradeBoardNo);

    @Transactional
    public void deleteByTradeBoardNo(String tradeBoardNo);

    @Query(value = "SELECT fn_seq('TBO')", nativeQuery = true)
    String getIdFromSeq();
}
