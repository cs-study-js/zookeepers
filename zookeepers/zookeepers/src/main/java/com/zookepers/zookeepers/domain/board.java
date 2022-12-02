package com.zookepers.zookeepers.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "board")
public class board {
    @Id
    @Column(name="Board_no")
    private String board_no;
    
    @Column(name="Member_no")
    private String member_no;

    @Column(name="Board_title")
    private String board_title;

    @Column(name="Board_detail")
    private String board_detail;

    @Column(name="Board_category")
    private String board_category;

    @Column(name="Board_date")
    private LocalDateTime board_date;

    @Column(name="Board_like")
    private int board_like;

    @Column(name="Board_bad")
    private int board_bad;

    @Column(name="Board_img")
    private String board_img;



}
