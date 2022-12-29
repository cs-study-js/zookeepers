package com.zookeepers.zookeepers.service.comment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zookeepers.zookeepers.dto.comment.CommentWriteRequestDto;
import com.zookeepers.zookeepers.entity.CommentEntity;
import com.zookeepers.zookeepers.repository.CommentRepository;
import com.zookeepers.zookeepers.repository.MemberRepository;

@Service
public class CommentServiceimpl implements CommentService{
    private final CommentRepository commentRepository;

    private final MemberRepository memberRepository;
    
    public CommentServiceimpl(CommentRepository commentRepository, MemberRepository memberRepository){
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void write(CommentWriteRequestDto commentDto) {

        String boardWriter = memberRepository.findByMemberNo(commentDto.getMemberNo()).getMemberNickname();     //Comment 작성자 닉네임
        String CommentNo = commentRepository.getIdFromSeq();                                                    //Comment 시퀀스
        CommentEntity commentEntity = commentDto.toEntity(CommentNo, boardWriter);                              //CommentWriteRequestDto -> CommentEntity
                    
        commentRepository.save(commentEntity);
    }

    @Override
    public String getCommentId() {
        return commentRepository.getIdFromSeq();
    }

    @Override
    public List<CommentEntity> commentList(String memberNo) {
        return commentRepository.findByBoardNo(memberNo);
    }
    
}