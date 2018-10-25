package edu.smu.event.vo;

import java.util.Date;

public class Event {

	private int num;
	private Date regdate;
	private String title;
	private String img_filename;
	private String content,event_start,event_end;
		
	public Event() {}
	
			
	public Event(int num, Date regdate, String title, String img_filename, String content, String event_start, String event_end) {
		this.num = num;
		this.regdate = regdate;
		this.title = title;
		this.img_filename = img_filename;
		this.content = content;
		this.setEvent_start(event_start);
		this.setEvent_end(event_end);
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


	public String getImg_filename() {
		return img_filename;
	}


	public void setImg_filename(String img_filename) {
		this.img_filename = img_filename;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getEvent_start() {
		return event_start;
	}


	public void setEvent_start(String event_start) {
		this.event_start = event_start;
	}


	public String getEvent_end() {
		return event_end;
	}


	public void setEvent_end(String event_end) {
		this.event_end = event_end;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event [num=");
		builder.append(num);
		builder.append(", regdate=");
		builder.append(regdate);
		builder.append(", event_start=");
		builder.append(event_start);
		builder.append(", event_end=");
		builder.append(event_end);
		builder.append(", title=");
		builder.append(title);
		builder.append(", img_filename=");
		builder.append(img_filename);
		builder.append(", content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	} 
	
	

}
