package com.zookeepers.zookeepers.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name="trade_comment")
@DynamicInsert
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeCommentEntity {
    @Id
    @Column(name="T_Com_no")
    private String tradeComNo;

	@JoinColumn(name = "Member_no")
    private String memberNo;

	@JoinColumn(name = "T_Board_no")
    private String tradeBoardNo;

    @Column(name="T_Com_detail")
    private String tradeComDetail;

    @Column(name="T_Com_date")
    private LocalDateTime tradeComDate;

    @Column(name="T_Com_class")
    private int tradeComClass;

    @Column(name="T_Com_order")
    private int tradeComOrder;

    @Column(name="T_Com_group")
    private int tradeComGroup;

    @Column(name="T_Com_writer")
    private String tradeComWriter;
}
