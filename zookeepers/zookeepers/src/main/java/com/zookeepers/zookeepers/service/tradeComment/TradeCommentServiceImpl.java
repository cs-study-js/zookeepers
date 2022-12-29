package com.zookeepers.zookeepers.service.tradeComment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zookeepers.zookeepers.dto.tradeBoard.TradeBoardCommentWriteRequestDto;
import com.zookeepers.zookeepers.entity.TradeCommentEntity;
import com.zookeepers.zookeepers.repository.MemberRepository;
import com.zookeepers.zookeepers.repository.TradeCommentRepository;

@Service
public class TradeCommentServiceImpl implements TradeCommentService{
    private final TradeCommentRepository tradeCommentRepository;

    private final MemberRepository memberRepository;
    
    public TradeCommentServiceImpl(TradeCommentRepository tradeCommentRepository, MemberRepository memberRepository){
        this.tradeCommentRepository = tradeCommentRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void write(TradeBoardCommentWriteRequestDto tradeCommentWriteRequestDto) {

        String boardWriter = memberRepository.findByMemberNo(tradeCommentWriteRequestDto.getMemberNo()).getMemberNickname();        //TradeComment작성자 닉네임 조회
        String tradeCommentNo = tradeCommentRepository.getIdFromSeq();                                                              //TradeComment 시퀀스

        TradeCommentEntity tradeCommentEntity = tradeCommentWriteRequestDto.toEntity(tradeCommentNo, boardWriter);                  //TradeCommentWriteRequestDto -> Entity
                    
        tradeCommentRepository.save(tradeCommentEntity);
    }

    @Override
    public String getTradeCommentId() {
        return tradeCommentRepository.getIdFromSeq();
    }

    @Override
    public List<TradeCommentEntity> tradeCommentList(String tradeBoardNo) {
        return tradeCommentRepository.findByTradeBoardNo(tradeBoardNo);
    }
    
}
