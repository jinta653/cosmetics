package edu.smu.board.vo;

import java.util.Date;

public class Comments {
	
	private int comments_num;
	private int num;
	private String userid;
	private String contents;
	private Date regdate;
	
	
	public Comments() {}
	
	public Comments(String contents, int num,String userid) {
		super();
		this.contents = contents;
		this.num = num;
		this.userid = userid;
	}

	
	public Comments(int comments_num, int num,String userid, String contents, Date regdate) {
		super();
		this.comments_num = comments_num;
		this.num = num;
		this.userid = userid;
		this.contents = contents;
		this.regdate = regdate;
	}
	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	

	public int getComments_num() {
		return comments_num;
	}



	public void setComments_num(int comments_num) {
		this.comments_num = comments_num;
	}



	public Date getRegdate() {
		return regdate;
	}



	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comments [comments_num=");
		builder.append(comments_num);
		builder.append(", num=");
		builder.append(num);
		builder.append(", userid=");
		builder.append(userid);
		builder.append(", contents=");
		builder.append(contents);
		builder.append(", regdate=");
		builder.append(regdate);
		builder.append("]");
		return builder.toString();
	}

	


}
