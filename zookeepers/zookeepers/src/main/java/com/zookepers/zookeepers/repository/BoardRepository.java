package com.zookepers.zookeepers.repository;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zookepers.zookeepers.Entity.board;

public interface BoardRepository extends JpaRepository <board,String>{
    public board save(board b);

    public List<board> findAll();

    public List<board> findAllByBoardtitle(String board_title);

    public List<board> findAllByBoardcategory(String board_category);

    public board findByBoardno(String board_no);

    @Transactional
    public void deleteByBoardno(String board_no);

    @Query(value = "SELECT fn_seq('ZBO')", nativeQuery = true)
    String getIdFromSeq();
}
