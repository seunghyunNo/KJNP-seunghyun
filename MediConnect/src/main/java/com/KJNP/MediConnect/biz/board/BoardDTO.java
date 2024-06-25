package com.KJNP.MediConnect.biz.board;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	
	private int boardIdx;
	private String title;
	private String content;
	private String id;
	private String writer;
	private Date regDate;
}
