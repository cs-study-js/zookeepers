package com.zookepers.zookeepers.Entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="comment")
@DynamicInsert
public class Comment {
    @Id
    @Column(name="Com_no")
    private String Com_no;

    public String getCom_no() {
        return this.Com_no;
    }

    public void setCom_no(String Com_no) {
        this.Com_no = Com_no;
    }

	@JoinColumn(name = "Member_no")
    private String Member_no;

    public String getMember_no() {
        return this.Member_no;
    }

    public void setMember_no(String Member_no) {
        this.Member_no = Member_no;
    }

	@JoinColumn(name = "Board_no")
    private String Board_no;

    public String getBoard_no() {
        return this.Board_no;
    }

    public void setBoard_no(String Board_no) {
        this.Board_no = Board_no;
    }

    @Column(name="Com_detail")
    private String Com_detail;

	public String getCom_detail() {
		return this.Com_detail;
	}

	public void setCom_detail(String Com_detail) {
		this.Com_detail = Com_detail;
	}


    @Column(name="Com_date")
    private LocalDateTime Com_date;

    public LocalDateTime getCom_date() {
        return this.Com_date;
    }

    public void setCom_date(LocalDateTime Com_date) {
        this.Com_date = Com_date;
    }

    @Column(name="Com_class")
    private int Com_class;

    public int getCom_class() {
        return this.Com_class;
    }

    public void setCom_class(int Com_class) {
        this.Com_class = Com_class;
    }

    @Column(name="Com_order")
    private int Com_order;

    public int getCom_order() {
        return this.Com_order;
    }

    public void setCom_order(int Com_order) {
        this.Com_order = Com_order;
    }

    @Column(name="Com_group")
    private int Com_group;

    public int getCom_group() {
        return this.Com_group;
    }

    public void setCom_group(int Com_group) {
        this.Com_group = Com_group;
    }

}
