package edu.smu.cosmetics.vo;

public class CosmeticsBrandVo {
	
	int cobrn_num;
	String cobrn_name;
	
	
	public CosmeticsBrandVo(int cobrn_num, String cobrn_name) {
		super();
		this.cobrn_num = cobrn_num;
		this.cobrn_name = cobrn_name;
	}
	public CosmeticsBrandVo() {
		super();
	}
	public int getCobrn_num() {
		return cobrn_num;
	}
	public void setCobrn_num(int cobrn_num) {
		this.cobrn_num = cobrn_num;
	}
	public String getCobrn_name() {
		return cobrn_name;
	}
	public void setCobrn_name(String cobrn_name) {
		this.cobrn_name = cobrn_name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CosmeticsBrandVo [cobrn_num=");
		builder.append(cobrn_num);
		builder.append(", cobrn_name=");
		builder.append(cobrn_name);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
