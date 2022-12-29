package com.zookeepers.zookeepers.service.board;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zookeepers.zookeepers.dto.board.BoardDetailResponseDto;
import com.zookeepers.zookeepers.dto.board.BoardListResponseDto;
import com.zookeepers.zookeepers.dto.board.BoardWriteRequestDto;
import com.zookeepers.zookeepers.entity.BoardEntity;
import com.zookeepers.zookeepers.entity.MemberEntity;

public interface BoardService {
    
    public void create(BoardWriteRequestDto boardWriteDto);
    
    public Page<BoardEntity> boardList(Pageable pageable);

    public List<BoardEntity> boardSearchTitle(String title);

    public List<BoardEntity> boardSearchCategory(String category);

    public BoardEntity findBoard(String boardNo);

    public void boardDelete(String boardNo);

    public String getBoardId();

}