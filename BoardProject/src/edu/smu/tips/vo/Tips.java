package edu.smu.tips.vo;

import java.util.Date;

public class Tips {
	
	private	int tips_num;
	private String tips_kind;
	private String tips_title;
	private String tips_writer;
	private String tips_content;
	private Date tips_regdate;
	private int tips_rate;
	
	public Tips() {}

	public Tips(int tips_num, String tips_kind, String tips_title, String tips_writer, String tips_content, Date tips_regdate,
			int tips_rate) {
		super();
		this.tips_num = tips_num;
		this.tips_kind = tips_kind;
		this.tips_title = tips_title;
		this.tips_writer = tips_writer;
		this.tips_content = tips_content;
		this.tips_regdate = tips_regdate;
		this.tips_rate = tips_rate;
	}
	
	
	public Tips(String tips_kind, String tips_title, String tips_writer, String tips_content) {
		super();
		this.tips_kind = tips_kind;
		this.tips_title = tips_title;
		this.tips_writer = tips_writer;
		this.tips_content = tips_content;
	}
	
	
	public String getTips_kind() {
		return tips_kind;
	}

	public void setTips_kind(String tips_kind) {
		this.tips_kind = tips_kind;
	}

	public int getTips_num() {
		return tips_num;
	}

	public void setTips_num(int tips_num) {
		this.tips_num = tips_num;
	}

	public String getTips_title() {
		return tips_title;
	}

	public void setTips_title(String tips_title) {
		this.tips_title = tips_title;
	}

	public String getTips_writer() {
		return tips_writer;
	}

	public void setTips_writer(String tips_writer) {
		this.tips_writer = tips_writer;
	}

	public String getTips_content() {
		return tips_content;
	}

	public void setTips_content(String tips_content) {
		this.tips_content = tips_content;
	}

	public Date getTips_regdate() {
		return tips_regdate;
	}

	public void setTips_regdate(Date tips_regdate) {
		this.tips_regdate = tips_regdate;
	}

	public int getTips_rate() {
		return tips_rate;
	}

	public void setTips_rate(int tips_rate) {
		this.tips_rate = tips_rate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tips [tips_num=");
		builder.append(tips_num);
		builder.append(", tips_kind=");
		builder.append(tips_kind);
		builder.append(", tips_title=");
		builder.append(tips_title);
		builder.append(", tips_writer=");
		builder.append(tips_writer);
		builder.append(", tips_content=");
		builder.append(tips_content);
		builder.append(", tips_regdate=");
		builder.append(tips_regdate);
		builder.append(", tips_rate=");
		builder.append(tips_rate);
		builder.append("]");
		return builder.toString();
	}

	
	

}
