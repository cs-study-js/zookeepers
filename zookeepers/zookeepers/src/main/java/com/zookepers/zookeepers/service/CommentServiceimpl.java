package com.zookepers.zookeepers.service;

import org.springframework.stereotype.Service;

import com.zookepers.zookeepers.Entity.Comment;
import com.zookepers.zookeepers.repository.CommentRepository;

@Service
public class CommentServiceimpl implements CommentService{
    final CommentRepository commentRepository;

    public CommentServiceimpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Override
    public void write(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public String getCommentId() {
        return commentRepository.getIdFromSeq();
    }
    
}
