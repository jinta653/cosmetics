package edu.smu.board.vo;

import java.util.Date;

public class Board {

	private int num;
	private Date regdate;
	private String title;
	private String writer;
	private String content;
	private int rate;
	
	public Board() {}
	
			
	public Board(int num, Date regdate, String title, String writer, String content, int rate) {
		this.num = num;
		this.regdate = regdate;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.rate = rate;

	
	}//end 
	
	public Board(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
		
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [num=");
		builder.append(num);
		builder.append(", regdate=");
		builder.append(regdate);
		builder.append(", title=");
		builder.append(title);
		builder.append(", writer=");
		builder.append(writer);
		builder.append(", content=");
		builder.append(content);
		builder.append(", rate=");
		builder.append(rate);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
