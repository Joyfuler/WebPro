package com.lec.ex02_protected;

// 메인함수에서 ChildIJ child = new ChildIJ(); 를 한다면?
public class ChildIJ extends SuperIJ {
	private int total;

	public ChildIJ() { // 상속받은 후 꼭 매개변수 x 생성자 넣어라!
		System.out.println("매개변수가 없는 ChildIJ의 생성자 함수");
		
	}
	public ChildIJ(int i, int j) { // 상속클래스이므로 사실 i,j를 받은 상태.
		System.out.println("매개변수 i,j가 있는 ChildIJ 생성자 함수. i,j 값이 초기화");
		// this.i = i; private인 경우 이 문법을 사용하면 오류. 다른 클래스에서 사용할 수 없기 때문. protected로 바꿔줌.
		this.i=i;
		setJ(j); // setJ는 public이므로 사용이 가능함. setJ에 j 변수 대입하는 방식으로 우회하였음.
	}
	public void sum() {
		total = i + getJ(); // J값 가져옴..
		System.out.println("i= " + i + ", j= " + getJ() + ", total =" + total); // J의 경우는 private이므로 set, get으로 접근하였음.
	}
	

}
