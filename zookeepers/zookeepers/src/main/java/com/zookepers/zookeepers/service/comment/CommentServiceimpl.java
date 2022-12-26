package com.zookepers.zookeepers.service.comment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zookepers.zookeepers.dto.CommentWriteDto;
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
    public void write(CommentWriteDto commentDto) {
        CommentEntity commentEntity = 
        CommentEntity.builder().
                     comNo(commentRepository.getIdFromSeq()).
                     comDetail(commentDto.getComDetail()).
                     comWriter(memberRepository.findByMemberNo(commentDto.getMemberNo()).getMemberNickname()).
                     memberNo(commentDto.getMemberNo()).
                     boardNo(commentDto.getBoardNo()).
                     comClass(0).
                     comDate(LocalDateTime.now()).
                     comGroup(0).
                     comOrder(0).
                     build();
                    
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