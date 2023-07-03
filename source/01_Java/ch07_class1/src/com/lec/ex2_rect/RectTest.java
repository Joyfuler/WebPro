package com.lec.ex2_rect;

public class RectTest {
	public static void main(String[] args) {
	Rect r1 = new Rect(3,5); // int width 등으로 수치를 초기화하는 과정이 귀찮다면?
	// test에 매개변수 2개 (int width, int height) 넣어서 생성자를 넣어줌. 이후 rect() 괄호 안에 숫자를 직접 넣어주자.
		
	Rect r2 = new Rect(7); // 매개변수 1에 대응하는 식. width = height = side;
	Rect r3 = new Rect(); // 매개변수가 없는 곳에 대응하는. 이 경우는 디폴트 생성자 함수로 감.
	System.out.println("r1: " + r1.getWidth() + "*" + r1.getHeight());
	System.out.println("r2: " + r2.getWidth() + "*" + r2.getHeight());
	
	
	System.out.println("r1의 넓이는: " + r1.area()); //0으로 출력됨.
	System.out.println("r2의 넓이는: " + r2.area());
	r1.setHeight(10);
	r1.setWidth(50);
	// System.out.println("사각형의 넓이는: " + r1.getHeight() * r1.getWidth());
	System.out.println("set를 새로 해줌. 높이 10 넓이 50인 경우 r1의 넓이는" + r1.area());
	
	// r3는 디폴트이므로 높이, 넓이 모두 0으로 되어 있음.
	r3.setWidth(10);
	System.out.println("r3 :" + r3.getHeight() +"*"+
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			r3.getWidth());
	System.out.println("r3의 넓이는" + r3.area());
	}

}
