package com.zookepers.zookeepers.service.board;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zookepers.zookeepers.dto.BoardWriteDto;
import com.zookepers.zookeepers.entity.BoardEntity;
import com.zookepers.zookeepers.repository.BoardRepository;
import com.zookepers.zookeepers.repository.MemberRepository;

@Service
public class BoardServiceimpl implements BoardService{

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public BoardServiceimpl(BoardRepository boardRepository, MemberRepository memberRepository){
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
    }
    
    @Override
    public void create(BoardWriteDto boardWriteDto) {
        BoardEntity boardEntity = BoardEntity.builder().
                boardNo(boardRepository.getIdFromSeq()).
                memberNo(boardWriteDto.getMemberNo()).
                boardWriter(memberRepository.findByMemberNo(boardWriteDto.getMemberNo()).getMemberNickname()).
                boardTitle(boardWriteDto.getBoardTitle()).
                boardCategory(boardWriteDto.getBoardCategory()).
                boardDetail(boardWriteDto.getBoardDetail()).
                boardImg(boardWriteDto.getBoardFile()).
                boardDate(LocalDateTime.now()).
                build();
                
        boardRepository.save(boardEntity);
    }

    @Override
    public Page<BoardEntity> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Override
    public List<BoardEntity> boardSearchTitle(String boardTitle) {
        return boardRepository.findByBoardTitle(boardTitle);
    }
                                                                                    
    @Override
    public List<BoardEntity> boardSearchCategory(String boardCategory) {
        return boardRepository.findByBoardCategory(boardCategory);
    }

    @Override
    public String getBoardId() {
        return boardRepository.getIdFromSeq();
    }

    @Override
    public BoardEntity findBoard(String boardNo) {
        return boardRepository.findByBoardNo(boardNo);
    }

    @Override
    public void boardDelete(String boardNo) {
        boardRepository.deleteByBoardNo(boardNo);        
    }
    
}