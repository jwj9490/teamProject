package travel.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	
	private final String must_input =" 필수 입력 사항입니다.";
	
	private int num;

	@NotBlank(message = "이름은" + must_input)
	private String name;
	
	@Range(min = 10, max = 100, message = "10살~100살 사이로 작성해야합니다.")
	private int age;
	
	@NotBlank(message = "관심지역은 1개 이상 선택해야 합니다.")
	private String area;
	
	@NotBlank(message = "여행 타입은" + must_input)
	private String style;
	
	@NotBlank(message = "가격 선택은" + must_input)
	private String price;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public TravelBean(int num, String name, int age, String area, String style, String price) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.area = area;
		this.style = style;
		this.price = price;
	}
	public TravelBean() {
		super();
	}
	
}
