package com.smhrd.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Board {

	private int idx;
	private String title;
	private String writer;
	private String content;
	private String img;
	private String indate;
	private int count;
	
	
}
