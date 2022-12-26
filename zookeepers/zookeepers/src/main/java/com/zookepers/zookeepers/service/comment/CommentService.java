package com.zookepers.zookeepers.service.comment;

import java.util.List;

import com.zookepers.zookeepers.dto.CommentWriteDto;
import com.zookepers.zookeepers.entity.CommentEntity;

public interface CommentService {
    public void write(CommentWriteDto commentDto);

    public String getCommentId();

    public List<CommentEntity> commentList(String boardNo);
}
