package com.KJNP.MediConnect.biz.comment;

import java.util.Date;

import lombok.Data;

@Data
public class CommentDTO {
	private int commentIdx;
	private int boardIdx;
	private String content;
	private String id;
	private String writer;
	private Date regDate;
}
