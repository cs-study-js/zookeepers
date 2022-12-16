package com.zookepers.zookeepers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zookepers.zookeepers.Entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, String>{
    public Comment save(Comment comment);
    
    @Query(value = "SELECT fn_seq('ZCM')", nativeQuery = true)
    String getIdFromSeq(); 
}
