package com.zookeepers.zookeepers.dto.comment;

import java.time.LocalDateTime;

import com.zookeepers.zookeepers.entity.CommentEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentWriteRequestDto {
    private String comDetail;

    private String memberNo;

    private String boardNo;

    private String boardWriter;

    private int comOrder;

    private int comClass;

    private int comGroup;

    public CommentEntity toEntity(String commentNo,String boardWriter){
        return CommentEntity.builder().
                     comNo(commentNo).
                     comDetail(comDetail).
                     comWriter(boardWriter).
                     memberNo(memberNo).
                     boardNo(boardNo).
                     comClass(comClass).
                     comDate(LocalDateTime.now()).
                     comGroup(comGroup).
                     comOrder(comOrder).
                     build();
    }
}
