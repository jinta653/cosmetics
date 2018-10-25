package edu.smu.cosmetics.vo;

public class Cosmetics {
	
	private int cos_num;
	private String name;
	private String capacity;
	private int price;
	private String explain;
	private String img_name;
	private int brand_num;
	private int kind_num;
	private int average;
	private String link;
	
	public Cosmetics() {}
	
	public Cosmetics(int cos_num, String img_name, String name, String explain, String capacity, int price) {
		super();
		this.cos_num = cos_num;
		this.img_name = img_name;
		this.name = name;
		this.explain = explain;
		this.capacity = capacity;
		this.price = price;
		
	}

	public Cosmetics(int cos_num, String name, String capacity, int price, String explain, String img_name,
			int brand_num, int kind_num, int average, String link) {
		super();
		this.cos_num = cos_num;
		this.name = name;
		this.capacity = capacity;
		this.price = price;
		this.explain = explain;
		this.img_name = img_name;
		this.brand_num = brand_num;
		this.kind_num = kind_num;
		this.average = average;
		this.link = link;
	}

	public int getCos_num() {
		return cos_num;
	}

	public void setCos_num(int cos_num) {
		this.cos_num = cos_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public int getBrand_num() {
		return brand_num;
	}

	public void setBrand_num(int brand_num) {
		this.brand_num = brand_num;
	}

	public int getKind_num() {
		return kind_num;
	}

	public void setKind_num(int kind_num) {
		this.kind_num = kind_num;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cosmetics [cos_num=");
		builder.append(cos_num);
		builder.append(", name=");
		builder.append(name);
		builder.append(", capacity=");
		builder.append(capacity);
		builder.append(", price=");
		builder.append(price);
		builder.append(", explain=");
		builder.append(explain);
		builder.append(", img_name=");
		builder.append(img_name);
		builder.append(", brand_num=");
		builder.append(brand_num);
		builder.append(", kind_num=");
		builder.append(kind_num);
		builder.append(", average=");
		builder.append(average);
		builder.append(", link=");
		builder.append(link);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
