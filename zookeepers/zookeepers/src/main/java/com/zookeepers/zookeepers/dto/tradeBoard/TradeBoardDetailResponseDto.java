package com.zookeepers.zookeepers.dto.tradeBoard;

import java.time.LocalDateTime;

import com.zookeepers.zookeepers.entity.MemberEntity;
import com.zookeepers.zookeepers.entity.TradeBoardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeBoardDetailResponseDto {
    String memberNo;
    String tradeBoardNo;
    String tradeBoardTitle;
    String tradeBoardDetail;
    String tradeBoardWriter;
    LocalDateTime tradeBoardDate;
    String memberTradeGrade;
    String tradeBoardImg;
    int tradeBoardPrice;
    String tradeBoardCategory;

    public TradeBoardDetailResponseDto(TradeBoardEntity boardEntity,MemberEntity memberEntity, String gradeCodeName, String categoryCodeName){

        this.memberNo = boardEntity.getMemberNo();
        this.tradeBoardNo = boardEntity.getTradeBoardNo();
        this.tradeBoardTitle = boardEntity.getTradeBoardTitle();
        this.tradeBoardWriter = boardEntity.getTradeBoardWriter();
        this.tradeBoardDate = boardEntity.getTradeBoardDate();
        this.tradeBoardImg = boardEntity.getTradeBoardImg();
        this.memberTradeGrade = gradeCodeName;
        this.tradeBoardCategory = categoryCodeName;
        this.tradeBoardDetail = boardEntity.getTradeBoardDetail();
        this.tradeBoardPrice = boardEntity.getTradeBoardPrice();
    }
}
