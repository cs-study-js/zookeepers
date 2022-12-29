package com.zookeepers.zookeepers.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="trade_board")
@Getter
@DynamicInsert
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TradeBoardEntity {
    @Id
    @Column(name="T_Board_no")
    private String tradeBoardNo;

	@JoinColumn(name = "member_no")
    private String memberNo;

    @Column(name="T_Board_title")
    private String tradeBoardTitle;

    @Column(name="T_Board_writer")
    private String tradeBoardWriter;

    @Column(name="T_Board_detail")
    private String tradeBoardDetail;

    @Column(name="T_Board_category")
    private String tradeBoardCategory;

    @Column(name="T_Board_date")
    private LocalDateTime tradeBoardDate;

    @Column(name="T_Board_tradestatus")
    private String tradeBoardStatus;

    @Column(name="T_Board_price")
    private int tradeBoardPrice;

    @Column(name="T_Board_img")
    private String tradeBoardImg;

}
