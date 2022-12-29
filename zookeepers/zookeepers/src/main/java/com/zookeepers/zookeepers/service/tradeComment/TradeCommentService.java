package com.zookeepers.zookeepers.service.tradeComment;

import java.util.List;

import com.zookeepers.zookeepers.dto.tradeBoard.TradeBoardCommentWriteRequestDto;
import com.zookeepers.zookeepers.entity.TradeCommentEntity;

public interface TradeCommentService {
    public void write(TradeBoardCommentWriteRequestDto commentDto);

    public String getTradeCommentId();

    public List<TradeCommentEntity> tradeCommentList(String tradeBoardNo);
}

