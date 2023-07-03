package com.lec.ex6_person;

public class PersonInfo {
	private String name;
	private int age;
	private char gender;
	public PersonInfo() { // 디폴트 생성자. (superclass generate해서 만들 수 있음.)
		}
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {
		System.out.println("이름 :" + name);
		System.out.println("나이 :" + age);
		System.out.println("성별 :" + gender); // 성별: m... 아무것도 없다면 출력X
		String str = (gender == 'm' || gender =='M' )? "男" : (gender =='f' || gender == 'F' ? "女": "성별없음");
		// System.out.println("성별:" + str);	//성별 출력.
		
		}
		
	public String infoPrint() {
		String str = (gender == 'm' || gender =='M' )? "男" : (gender =='f' || gender == 'F' ? "女": "성별없음");
		String result = "이름 :" + name + "\n" + "나이 :" + age + "\n" + "성별: " + str; //str은 그냥쓸수 없으므로 위에 설정해준거 다시 복붙해줌
		// 혹은 한줄씩도 가능
		String result2 = "이름: " + name;
		result2 += "\n나이: " +age;
		result2 += "\n성별: " +gender;
		return result2;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
		
	
	}
	

	
	
	
	
	
	

