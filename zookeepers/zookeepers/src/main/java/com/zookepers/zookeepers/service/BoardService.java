package com.zookepers.zookeepers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zookepers.zookeepers.Entity.board;

public interface BoardService {
    
    public void create(board b);
    
    public Page<board> board_list(Pageable pageable);

    public List<board> board_search_title(String title);

    public List<board> board_search_category(String category);

    public board find_board(String boardNo);

    public void board_delete(String boardNo);

    public String getBoardId();
}
