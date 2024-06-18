package com.KJNP.MediConnect.biz.board;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private String title;
	private String content;
	private Date time;
}
