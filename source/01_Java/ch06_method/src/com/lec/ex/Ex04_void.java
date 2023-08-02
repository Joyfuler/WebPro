package com.lec.ex;

public class Ex04_void {
 //return이 없는 메소드.. 줄을 그리는 방법?
	private static void printLine() { // 매개변수 없음, 리턴타입도 없는 메소드
		for (int i = 0; i <= 20; i++) {
			System.out.print('-');
		}
			System.out.println(); //기본 라인을 그린 후 개행
	}
	
	public static void printLine(char c) {
		for (int i = 0; i <= 20; i++) {
			System.out.print(c);
		}
			System.out.println(); //기본 라인을 그린 후 개행
	}
	
		
		


	
	public static void printLine(int cnt) { // cnt에 앞 15가 대입됨.
		for (int i = 0; i < cnt; i++) { // 15번 반복하게 만듬. (기존 20줄이 아니라 입력한 숫자만큼의 줄 수를 출력하기 위함)
			System.out.print('-');
		}
			System.out.println(); //기본 라인을 그린 후 개행
			
			
			
	}
	
	public static void printLine(int cnt, char c) { // 두 개의 변수에 대응하도록 한 개 매개변수를 더 추가. (오버로딩)
		for (int i = 0; i < cnt; i++) { // 15번 반복하게 만듬.
			System.out.print(c); // 메인메소드에서 prinLine에 입력한 부분이 출력됨.
		}
			System.out.println(); //기본 라인을 그린 후 개행

	
	}
	public static void main(String[] args) {
		printLine(); // printLine(); 변수 없이 위 메소드대로 그대로 실행( -------------를 하고 개행) 
		System.out.println("Hello, Java"); // 이후 Hello Java를 출력시킴.
		printLine('~'); // ~~~~~~~를 쓰고 싶다면? char 변수를 추가함. (-----) 자체 대신 c에  ~를 대입해 들어가도록 한 후, 위 메소드에서 20번 반복.
		System.out.println("Hello, Oracle DB");
		printLine(15); // int 변수를 만들지 않으면 본래 오류가 나므로 새로 메소드를 생성해줌. 위에 int cnt가 있는 메소드를 새로 생성.
		System.out.println("Hello, Void");
		printLine(20, '#'); // 21줄, #으로 되어 있는 라인을 출력하려면 2개 변수여서 또 오류가 나므로 위에 변수가 2개 있는 메소드를 또 만들어줌.
		
	}
}
