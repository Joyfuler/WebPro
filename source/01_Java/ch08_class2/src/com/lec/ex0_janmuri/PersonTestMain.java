package com.lec.ex0_janmuri;


public class PersonTestMain {
	public static void main(String[] args) { // 본 메인 함수는 static. 이런 경우는 컴퓨터가 무조건 따로 업로드함. 
		// 하지만 메인 함수 외에 static이 또 생긴다면? 해당 메소드는 main처럼 따로  메모리 영역이 확보됨. static을 많이 쌓으면 메모리 부하가 올 수 있다는 단점존재.
		// 컴퓨터의 garvage collection은 static에는 사용하지 않기 때문.
		PersonInfo p1 = new PersonInfo("홍", 20, 'm');
		PersonInfo[] p2 = {p1, new PersonInfo("홍길순",24,'f')};
		p1.print();
	}
} // 밑은 다른 클래스이므로 } 를 쳐서 구분해줌.

class PersonInfo { // public이 아닌 클래스를 하나 더 넣을 수 있음.
					// 단, public class는 한 개만 넣을 수 있음. (두개 넣을시 오류)
	 private String name;
	 private int age;
	 private char gender;
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	 public void print() {
		 System.out.println("이름 : " + name + ", 나이 : " + age + ", 성별 : " + gender);
	 }
}
	 
	 // public 없이 같은 클래스에서 2개를 사용할 수는 있지만, 다른 곳 or 다른 사람이 사용하지 못하게 됨.
	 // 따라서 public 하나씩을 넣고 다른 클래스에서 사용하는 것이 권장됨.
	 // 또한 컴파일하는 경우는 결과적으로 bin에서 2개의 class 파일이 생기므로 같은 클래스 2개는 비추천




		
		
		




