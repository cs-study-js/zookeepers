package com.zookeepers.zookeepers.dto.board;

import java.time.LocalDateTime;

import com.zookeepers.zookeepers.entity.BoardEntity;
import com.zookeepers.zookeepers.entity.MemberEntity;

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
public class BoardDetailResponseDto {

    private String memberNo;

    private String boardNo;

    private String boardTitle;

    private String boardWriter;

    private LocalDateTime boardDate;

    private String memberGrade;

    private String boardImg;    

    private String boardCategory;

    private String boardDetail;

    private int boardLike;

    private int boardBad;

    public BoardDetailResponseDto(BoardEntity boardEntity, String gradeCodeName, String categoryCodeName){       //Entity -> Dto

        this.memberNo = boardEntity.getMemberNo();
        this.boardNo = boardEntity.getBoardNo();
        this.boardTitle = boardEntity.getBoardTitle();
        this.boardWriter = boardEntity.getBoardWriter();
        this.boardDate = boardEntity.getBoardDate();
        this.boardImg = boardEntity.getBoardImg();
        this.memberGrade = gradeCodeName;
        this.boardCategory = categoryCodeName;
        this.boardDetail = boardEntity.getBoardDetail();
        this.boardLike = boardEntity.getBoardLike();
        this.boardBad = boardEntity.getBoardBad();
        
    }
}


