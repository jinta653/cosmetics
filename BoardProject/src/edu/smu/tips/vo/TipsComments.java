package edu.smu.tips.vo;

import java.util.Date;

public class TipsComments {

	private int tips_comments_num;
	private int tips_num;
	private String tips_contents;
	private Date tips_regdate;
	
	public TipsComments() {}
	
	
	
	public TipsComments(String tips_contents, int tips_num) {
		super();
		this.tips_contents = tips_contents;
		this.tips_num = tips_num;
	}



	public TipsComments(int tips_comments_num, int tips_num, String tips_contents, Date tips_regdate) {
		super();
		this.tips_comments_num = tips_comments_num;
		this.tips_num = tips_num;
		this.tips_contents = tips_contents;
		this.tips_regdate = tips_regdate;
	}

	public int getTips_comments_num() {
		return tips_comments_num;
	}

	public void setTips_comments_num(int tips_comments_num) {
		this.tips_comments_num = tips_comments_num;
	}

	public int getTips_num() {
		return tips_num;
	}

	public void setTips_num(int tips_num) {
		this.tips_num = tips_num;
	}

	public String getTips_contents() {
		return tips_contents;
	}

	public void setTips_contents(String tips_contents) {
		this.tips_contents = tips_contents;
	}

	public Date getTips_regdate() {
		return tips_regdate;
	}

	public void setTips_regdate(Date tips_regdate) {
		this.tips_regdate = tips_regdate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TipsComments [tips_comments_num=");
		builder.append(tips_comments_num);
		builder.append(", tips_num=");
		builder.append(tips_num);
		builder.append(", tips_contents=");
		builder.append(tips_contents);
		builder.append(", tips_regdate=");
		builder.append(tips_regdate);
		builder.append("]");
		return builder.toString();
	}
	
}
