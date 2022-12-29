package com.zookeepers.zookeepers.dto.board;

import java.time.LocalDateTime;

import com.zookeepers.zookeepers.entity.BoardEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardWriteRequestDto {
    
    private String boardTitle;

    private String boardDetail;

    private String boardFile;

    private String boardCategory;

    private String memberNo;

    private String boardWriter;

    private String boardImg;

    public BoardEntity toEntity(String boardNo, String boardWriter){        //Dto -> Entity
        return BoardEntity.builder().
               boardNo(boardNo).
               memberNo(memberNo).
               boardTitle(boardTitle).
               boardWriter(boardWriter).
               boardDetail(boardDetail).
               boardCategory(boardCategory).
               boardDate(LocalDateTime.now()).
               boardImg(boardImg).build();
    }
}
