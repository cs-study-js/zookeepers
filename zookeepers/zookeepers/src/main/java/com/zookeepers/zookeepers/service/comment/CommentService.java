package com.zookeepers.zookeepers.service.comment;

import java.util.List;

import com.zookeepers.zookeepers.dto.comment.CommentWriteRequestDto;
import com.zookeepers.zookeepers.entity.CommentEntity;

public interface CommentService {
    public void write(CommentWriteRequestDto commentDto);

    public String getCommentId();

    public List<CommentEntity> commentList(String boardNo);
}
