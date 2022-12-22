package com.zookepers.zookeepers.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name="comment")
@DynamicInsert
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {
    @Id
    @Column(name="Com_no")
    private String comNo;

	@JoinColumn(name = "Member_no")
    private String memberNo;

	@JoinColumn(name = "Board_no")
    private String boardNo;

    @Column(name="Com_detail")
    private String comDetail;

    @Column(name="Com_date")
    private LocalDateTime comDate;

    @Column(name="Com_class")
    private int comClass;

    @Column(name="Com_order")
    private int comOrder;

    @Column(name="Com_group")
    private int comGroup;

    @Column(name="Com_wirter")
    private String comWriter;
}
