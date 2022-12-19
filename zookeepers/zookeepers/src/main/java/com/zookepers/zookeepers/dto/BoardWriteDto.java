package com.zookepers.zookeepers.dto;

import lombok.Data;

@Data
public class BoardWriteDto {
    
    private String boardTitle;

    private String boardDetail;

    private String boardFile;

    private String boardCategory;

    private String memberNo;

    private String boardWriter;

}
