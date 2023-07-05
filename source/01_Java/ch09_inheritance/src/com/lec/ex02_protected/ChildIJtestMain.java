package com.lec.ex02_protected;

public class ChildIJtestMain {

	public static void main(String[] args) {
		ChildIJ child1 = new ChildIJ();
		child1.setI(1); 
		child1.setJ(2); // i와 j의 값을 각각 1,2로 set 해주었음. ChildIJ로 올라가서 계산.
		child1.sum(); // ChildIJ의 i+j가 들어있는 sum 메소드를 실행하였음.
		
		System.out.println("-----------------");
		
		ChildIJ child2 = new ChildIJ(10,20); // i와 j에 수를 대입. 그러나 부모클래스에서 i,j를 이식할 수가 없음..
		// 두줄 출력. 하나는 SuperIJ 데이터, 하나는 CHildIJ 데이터가 출력된 것.
		// 부모클래스의 경우는 무조건 매개변수가 없는 쪽이 출력됨. 자식클래스에는 정상적으로 10,20 매개변수 2개가 대입되었음.
		child2.sum();
	}

}
