package com.zookepers.zookeepers.service.comment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zookepers.zookeepers.dto.comment.CommentWriteRequestDto;
import com.zookepers.zookeepers.entity.CommentEntity;
import com.zookepers.zookeepers.repository.CommentRepository;
import com.zookepers.zookeepers.repository.MemberRepository;

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