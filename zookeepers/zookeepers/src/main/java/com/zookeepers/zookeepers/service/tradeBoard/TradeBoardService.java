package com.zookeepers.zookeepers.service.tradeBoard;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zookeepers.zookeepers.dto.tradeBoard.TradeBoardWriteRequestDto;
import com.zookeepers.zookeepers.entity.TradeBoardEntity;

import org.springframework.data.domain.Page;

public interface TradeBoardService {
    
    public void create(TradeBoardWriteRequestDto tradeBoardWriteDto, String memberNo);
    
    public Page<TradeBoardEntity> tradeBoardList(Pageable pageable);

    public List<TradeBoardEntity> tradeBoardSearchTitle(String title);

    public List<TradeBoardEntity> tradeBoardSearchCategory(String category);

    public TradeBoardEntity findTradeBoard(String tradeBoardNo);

    public void tradeBoardDelete(String tradeBoardNo);

    public String getTradeBoardId();
}
