package com.zookepers.zookeepers.Entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "board")
@DynamicInsert
public class board {
    @Id
    @Column(name="Board_no")
    private String boardno;

    public Object getBoard_no() {
        return this.boardno;
    }

    public void setBoard_no(String board_no) {
        this.boardno = board_no;
    }

	@JoinColumn(name = "member_no")
    private String member_no;

    public String getMember_no() {
        return this.member_no;
    }

    public void setMember_no(String member_no) {
        this.member_no = member_no;
    }

    @Column(columnDefinition="serial")
    private long board_idn;

	public long getBoard_idn() {
		return this.board_idn;
	}

	public void setBoard_idn(long board_idn) {
		this.board_idn = board_idn;
	}


    @Column(name="Board_title")
    private String boardtitle;

    public String getBoard_title() {
		return this.boardtitle;
	}  

	public void setBoard_title(String board_title) {
		this.boardtitle = board_title;
	}

    @Column(name="Board_writer")
    private String board_writer;

    public String getBoard_writer() {
        return this.board_writer;
    }

    public void setBoard_writer(String board_writer) {
        this.board_writer = board_writer;
    }

    @Column(name="Board_detail")
    private String board_detail;

    public String getBoard_detail() {
		return this.board_detail;
	}  

	public void setBoard_detail(String board_detail) {
		this.board_detail = board_detail;
	}
    @Column(name="Board_category")
    private String boardcategory;

    public String getBoard_category(){
        return this.boardcategory;
    }

    public void setBoard_category(String board_category){
        this.boardcategory = board_category;
    }

    @Column(name="Board_date")
    private LocalDateTime board_date;

    public LocalDateTime getBoard_date() {
		return this.board_date;
	}

	public void setBoard_date(LocalDateTime board_date) {
		this.board_date = board_date;
	}


    @Column(name="Board_like")
    private int board_like;

    public int getBoard_like() {
        return this.board_like;
    }

    public void setBoard_like(int board_like) {
        this.board_like = board_like;
    }

    @Column(name="Board_bad")
    private int board_bad;

    public int getBoard_bad() {
        return this.board_bad;
    }

    public void setBoard_bad(int board_bad) {
        this.board_bad = board_bad;
    }

    @Column(name="Board_img")
    private String board_img;

	public String getBoard_img() {
		return this.board_img;
	}

	public void setBoard_img(String board_img) {
		this.board_img = board_img;
	}

}
