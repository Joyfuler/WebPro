package com.lec.ex4_human;
//데이터, 생성자 함수(public), 메소드, 세터게터 순서대로 쓸 것.
// Man kim = new Man ("홍길동", 22, 180, 68.0);  생성자 함수의 오버로딩
// Man kim = (); 매개변수없음
// Man kim new Man ("홍길동");
// Man kim new Man (180);
// Man kim new Man (68.0); // 소숫점은 double로 사용할 것.

public class Man {
	private String name;
	private int age;
	private int height;
	private double weight; // 68 넣어도 알아서 68.0이 됨
	// 개발자가 생성자 함수를 하나 이상 만들면 컴파일러는 디폴트 생성자 함수 만들지 않음.
	// 그러나 생성자 함수를 아무것도 만들지 않으면 컴파일러는 디폴트 생성자 함수를 만듬.
	
	public Man() {
		System.out.println("매개변수가 없는 Man 생성자가 출력되는지?");
	}

	public Man(String name, int age, int height, double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("데이터 4개를 초기화하는 Man 생성자 함수");
	}
	
	public Man(String name) {
		this.name = name;
		System.out.println("이름을 초기화하는 Man 생성자 함수");
	
	}
	public Man(int height) {
		this.height= height;
		System.out.println("키를 초기화하는 Man 생성자 함수");
	}
	
	public Man(double weight) {
		this.weight = weight;
		System.out.println("몸무게를 초기화하는 Man 생성자 함수");
	}
	
	
	//BMI 지수를 계산하는 메소드
	public double calculateBMI() {
		double result = weight / (((double)height/100) * ((double)height/100)); 
		return result; // BMI를 계산해 준 후 result를 반환해줌	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
	

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	
	
	
	//Setter getter 자동생성
	
	
	
	}
	
	
	
//	public Man(String name, int age, int height, double weight) {
//		this.name = name;
//		this.age = age;
//		this.height = height;
//		this.weight = weight; // 내 객체로 들어온 weight를 여기에 있는 매개변수로 초기화
		
	
	
	
	
	

	

	
	// 똑같은 kim이라는 함수 이름이 매개변수 숫자에 따라서 자동으로 선택되어 적용.

