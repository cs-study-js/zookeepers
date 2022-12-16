package com.zookepers.zookeepers.service;

import com.zookepers.zookeepers.Entity.Comment;

public interface CommentService {
    public void write(Comment comment);

    public String getCommentId();
}
