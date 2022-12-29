package com.zookeepers.zookeepers.dto.tradeBoard;

import java.time.LocalDateTime;

import com.zookeepers.zookeepers.entity.TradeBoardEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeBoardWriteRequestDto {
    
    private String tradeBoardTitle;

    private String tradeBoardDetail;

    private String tradeBoardFile;

    private String tradeBoardCategory;

    private int tradeBoardPrice;

    private String memberNo;

    private String tradeBoardWriter;

    private String tradeBoardImg;

    private LocalDateTime tradeBoardDate;

    private String tradeBoardStatus;

    public TradeBoardEntity toEntity(String boardNo, String memberNo,String tradeBoardWriter){
        return TradeBoardEntity.builder().
               tradeBoardNo(boardNo).
               tradeBoardTitle(tradeBoardTitle).
               tradeBoardDetail(tradeBoardDetail).
               tradeBoardCategory(tradeBoardCategory).
               tradeBoardPrice(tradeBoardPrice).
               memberNo(memberNo).
               tradeBoardWriter(tradeBoardWriter).
               tradeBoardImg(tradeBoardImg).
               tradeBoardStatus(tradeBoardStatus).
               tradeBoardDate(LocalDateTime.now()).build();
    }
}