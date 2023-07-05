package com.lec.ex02_protected;

public class SuperIJ {
	protected int i; // i=20; 등으로 초기화 x, 외부에서 데이터를 가져오는 경우가 대부분이기 때문.
	private int j; // 외부에서 데이터 사용할 일이 절대 없다면 get,set 사용 x.. 하지만 만드는게 편함.
	
	public SuperIJ() { // SuperIJ 클래스에 대한 디폴트 함수. 상속받은 클래스에서 무조건실행됨. SuperIJ();...
					   // 없는 경우에는 extends를 실행한 ChilduIJ.java 가 에러남.
		System.out.println("매개변수 없는 SuperIJ 생성자 함수");
	}

	public SuperIJ(int i, int j) { // i와 j를 모두 사용하는 생성자 함수 자동생성.
		System.out.println("매개변수 있는 SuperIJ 생성자 함수. i와 j값이 초기화");
		this.i = i;
		this.j = j;
	}

	public int getI() { // get,set 자동생성.
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	
	
	
}
