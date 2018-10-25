package edu.smu.cosmetics.vo;

public class CosmeticsBrandKindVo {
	
	int cokin_num;
	String cokin_name;
	
	
	public CosmeticsBrandKindVo() {
		super();
	}
	public CosmeticsBrandKindVo(int cokin_num, String cokin_name) {
		super();
		this.cokin_num = cokin_num;
		this.cokin_name = cokin_name;
	}
	public int getCokin_num() {
		return cokin_num;
	}
	public void setCokin_num(int cokin_num) {
		this.cokin_num = cokin_num;
	}
	public String getCokin_name() {
		return cokin_name;
	}
	public void setCokin_name(String cokin_name) {
		this.cokin_name = cokin_name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CosmeticsBrandKindVo [cokin_num=");
		builder.append(cokin_num);
		builder.append(", cokin_name=");
		builder.append(cokin_name);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
