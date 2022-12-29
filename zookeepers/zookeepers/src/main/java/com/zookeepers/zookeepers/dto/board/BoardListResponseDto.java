package com.zookeepers.zookeepers.dto.board;

import java.time.LocalDateTime;


import com.zookeepers.zookeepers.entity.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardListResponseDto {
    
    private String boardNo;
    private String boardTitle;
    private String boardWriter;
    private LocalDateTime boardDate;

    public BoardListResponseDto(BoardEntity boardEntity){
        this.boardNo = boardEntity.getBoardNo();
        this.boardDate = boardEntity.getBoardDate();
        this.boardWriter = boardEntity.getBoardWriter();
        this.boardTitle = boardEntity.getBoardTitle();
    }
}
