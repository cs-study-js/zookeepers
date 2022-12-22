package com.zookepers.zookeepers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentWriteDto {
    private String comDetail;

    private String memberNo;

    private String boardNo;

    private String boardWriter;

    private int comOrder;

    private int comClass;

    private int comGroup;
}
