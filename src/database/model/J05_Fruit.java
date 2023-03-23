package database.model;

public class J05_Fruit {
	
	// DB에서 가져온 데이터에는 null이 포함될 수 있기 때문에
	// 기본형 보다는 참조형 타입을 사용하는 것이 마음 편하다.
	private String name;
	private Double sweet;
	private Integer price;
	private String country_id;
	private String apple_grade;
	
		
	// 기본 생성자가 존재하는 것이 좋다
	public J05_Fruit() {}
	
	
	// JComboBox에서 사용할 J05_Fruit 생성자 생성
	public J05_Fruit(String name, Double sweet, Integer price, String country_id, String apple_grade) {
		this.name = name;
		this.sweet = sweet;
		this.price = price;
		this.country_id = country_id;
		this.apple_grade = apple_grade;
	}
	
	
	// 마우스 우클릭 Source → Generate Getter and Setter → Select All
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getSweet() {
		return sweet;
	}


	public void setSweet(Double sweet) {
		this.sweet = sweet;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public String getCountry_id() {
		return country_id;
	}


	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}


	public String getApple_grade() {
		return apple_grade;
	}


	public void setApple_grade(String apple_grade) {
		this.apple_grade = apple_grade;
	}

	@Override
	public String toString() {
		return String.format("%s/%.2f", name, sweet);
	}
}
