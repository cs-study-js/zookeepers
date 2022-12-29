package com.zookeepers.zookeepers.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name = "board")
@DynamicInsert
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {
    @Id
    @Column(name="Board_no")
    private String boardNo;

	@JoinColumn(name = "member_no")
    private String memberNo;

    @Column(name="Board_title")
    private String boardTitle;

    @Column(name="Board_writer")
    private String boardWriter;

    @Column(name="Board_detail")
    private String boardDetail;

    @Column(name="Board_category")
    private String boardCategory;

    @Column(name="Board_date")
    private LocalDateTime boardDate;

    @Column(name="Board_like")
    private int boardLike;

    @Column(name="Board_bad")
    private int boardBad;

    @Column(name="Board_img")
    private String boardImg;

}
