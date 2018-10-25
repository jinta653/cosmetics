package edu.smu.customer.vo;

public class Customer {
	
	private String email;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private int telNum;
	
	public Customer() {}
	
	
	public Customer(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public Customer(String email, String password, String name, String birth, String gender, int telNum) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.telNum = telNum;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getTelNum() {
		return telNum;
	}
	public void setTelNum(int telNum) {
		this.telNum = telNum;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("customer [email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", name=");
		builder.append(name);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", telNum=");
		builder.append(telNum);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	

}
