package com.zookepers.zookeepers.service.tradeBoard;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import com.zookepers.zookeepers.dto.tradeBoard.TradeBoardWriteRequestDto;
import com.zookepers.zookeepers.entity.TradeBoardEntity;
import com.zookepers.zookeepers.repository.MemberRepository;
import com.zookepers.zookeepers.repository.TradeBoardRepository;

@Service
public class TradeBoardServiceImpl implements TradeBoardService {

    private final TradeBoardRepository tradeBoardRepository;
    private final MemberRepository memberRepository;

    TradeBoardServiceImpl(TradeBoardRepository tradeBoardRepository, MemberRepository memberRepository){
        this.tradeBoardRepository = tradeBoardRepository;
        this.memberRepository = memberRepository;        
    }

    @Override
    public void create(TradeBoardWriteRequestDto tradeBoardWriteDto,String memberNo) {
        String tradeBoardWriter = memberRepository.findByMemberNo(memberNo).getMemberNickname();                       //tradeBoardWriter value 조회
        String tradeBoardNo = tradeBoardRepository.getIdFromSeq();                                                      //tradeBoardNo 시퀀스값 생성
        TradeBoardEntity tradeBoardEntity = tradeBoardWriteDto.toEntity(tradeBoardNo ,memberNo, tradeBoardWriter);      //tradeBoardWriteDto-> tradeBoardEntity
        
        tradeBoardRepository.save(tradeBoardEntity);                                                                    // tradeBoardEntity값 repository로 전송 
    }

    @Override
    public Page<TradeBoardEntity> tradeBoardList(Pageable pageable) {
        return tradeBoardRepository.findAll(pageable);
    }

    @Override
    public List<TradeBoardEntity> tradeBoardSearchTitle(String title) {
        return null;
    }

    @Override
    public List<TradeBoardEntity> tradeBoardSearchCategory(String category) {
        return null;
    }

    @Override
    public TradeBoardEntity findTradeBoard(String tradeBoardNo) {

        return tradeBoardRepository.findByTradeBoardNo(tradeBoardNo);
    }

    @Override
    public void tradeBoardDelete(String tradeBoardNo) {
        tradeBoardRepository.deleteByTradeBoardNo(tradeBoardNo);                                                    //판매글 삭제
    }

    @Override
    public String getTradeBoardId() {
        return tradeBoardRepository.getIdFromSeq();
    }
}
