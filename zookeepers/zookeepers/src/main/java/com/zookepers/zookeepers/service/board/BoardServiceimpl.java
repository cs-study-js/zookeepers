package com.zookepers.zookeepers.service.board;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zookepers.zookeepers.dto.board.BoardWriteRequestDto;
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
    public void create(BoardWriteRequestDto boardWriteRequestDto) {
    
        String boardWriter = memberRepository.findByMemberNo(boardWriteRequestDto.getMemberNo()).getMemberNickname();  //boardWriter value 조회
        String boardNo = boardRepository.getIdFromSeq();                                                                //boardNo 시퀀스값 생성

        BoardEntity boardEntity = boardWriteRequestDto.toEntity(boardNo,  boardWriter);                                //boardWriteDto-> boardEntity
        
        boardRepository.save(boardEntity);                                                                              // boardEntity값 repository로 전송 
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
        boardRepository.deleteByBoardNo(boardNo);        // 게시판 삭제
    }
    
}