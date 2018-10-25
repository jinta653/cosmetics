package edu.smu.event.vo;

import java.util.Date;

public class Event_Comments {
	
	private int event_comments_num;
	private int event_num;
	private String event_contents;
	private Date event_regdate;
	
	public Event_Comments() {}

	public Event_Comments(String event_contents, int event_num) {
		super();
		this.event_contents = event_contents;
		this.event_num = event_num;
	}
	
	public Event_Comments(int event_comments_num, int event_num, String event_contents, Date event_regdate) {
		super();
		this.event_comments_num = event_comments_num;
		this.event_num = event_num;
		this.event_contents = event_contents;
		this.event_regdate = event_regdate;
	}

	public int getEvent_comments_num() {
		return event_comments_num;
	}

	public void setEvent_comments_num(int event_comments_num) {
		this.event_comments_num = event_comments_num;
	}

	public int getEvent_num() {
		return event_num;
	}

	public void setEvent_num(int event_num) {
		this.event_num = event_num;
	}

	public String getEvent_contents() {
		return event_contents;
	}

	public void setEvent_contents(String event_contents) {
		this.event_contents = event_contents;
	}

	public Date getEvent_regdate() {
		return event_regdate;
	}

	public void setEvent_regdate(Date event_regdate) {
		this.event_regdate = event_regdate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event_Comments [event_comments_num=");
		builder.append(event_comments_num);
		builder.append(", event_num=");
		builder.append(event_num);
		builder.append(", event_contents=");
		builder.append(event_contents);
		builder.append(", event_regdate=");
		builder.append(event_regdate);
		builder.append("]");
		return builder.toString();
	}
	
	


}
