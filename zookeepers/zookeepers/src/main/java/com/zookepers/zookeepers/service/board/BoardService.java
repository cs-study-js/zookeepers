package com.zookepers.zookeepers.service.board;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zookepers.zookeepers.dto.BoardWriteDto;
import com.zookepers.zookeepers.entity.BoardEntity;

public interface BoardService {
    
    public void create(BoardWriteDto boardWriteDto);
    
    public Page<BoardEntity> boardList(Pageable pageable);

    public List<BoardEntity> boardSearchTitle(String title);

    public List<BoardEntity> boardSearchCategory(String category);

    public BoardEntity findBoard(String boardNo);

    public void boardDelete(String boardNo);

    public String getBoardId();
}