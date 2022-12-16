package com.zookepers.zookeepers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zookepers.zookeepers.Entity.board;
import com.zookepers.zookeepers.repository.BoardRepository;

@Service
public class BoardServiceimpl implements BoardService{

    final BoardRepository boardRepository;

    public BoardServiceimpl(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }
    
    @Override
    public void create(board b) {
        boardRepository.save(b);
    }

    @Override
    public Page<board> board_list(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Override
    public List<board> board_search_title(String title) {
        System.out.println(boardRepository.findAllByBoardtitle(title));
        return boardRepository.findAllByBoardtitle(title);
    }
    
    @Override
    public List<board> board_search_category(String category) {
        return boardRepository.findAllByBoardcategory(category);
    }

    @Override
    public String getBoardId() {
        return boardRepository.getIdFromSeq();
    }

    @Override
    public board find_board(String boardNo) {
        return boardRepository.findByBoardno(boardNo);
    }

    @Override
    public void board_delete(String boardNo) {
        boardRepository.deleteByBoardno(boardNo);        
    }
    
}