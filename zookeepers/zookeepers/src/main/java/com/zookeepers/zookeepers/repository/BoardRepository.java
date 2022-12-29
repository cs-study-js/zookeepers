package com.zookeepers.zookeepers.repository;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zookeepers.zookeepers.entity.BoardEntity;

public interface BoardRepository extends JpaRepository <BoardEntity, String>{
    public BoardEntity save(BoardEntity b);

    public List<BoardEntity> findAll();

    public List<BoardEntity> findByBoardTitle(String boardTitle);

    public List<BoardEntity> findByBoardCategory(String boardCategory);

    public BoardEntity findByBoardNo(String boardNo);

    @Transactional
    public void deleteByBoardNo(String boardNo);

    @Query(value = "SELECT fn_seq('ZBO')", nativeQuery = true)
    String getIdFromSeq();
}
