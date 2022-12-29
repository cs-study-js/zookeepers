package com.zookeepers.zookeepers.dto.tradeBoard;

import java.time.LocalDateTime;

import com.zookeepers.zookeepers.entity.TradeCommentEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeBoardCommentWriteRequestDto {
    private String tradeComDetail;

    private String memberNo;

    private String tradeBoardNo;

    private String tradeComWriter;

    private int tradeComOrder;

    private int tradeComClass;

    private int tradeComGroup;

    private LocalDateTime tradeComDate;

    public TradeCommentEntity toEntity(String tradeComNo, String tradeComWriter){
        return TradeCommentEntity.builder().
               tradeComNo(tradeComNo).
               tradeComDetail(tradeComDetail).
               memberNo(memberNo).
               tradeBoardNo(tradeBoardNo).
               tradeComWriter(tradeComWriter).
               tradeComOrder(tradeComOrder).
               tradeComClass(tradeComClass).
               tradeComGroup(tradeComGroup).
               tradeComDate(LocalDateTime.now()).
               build();
    }
}
