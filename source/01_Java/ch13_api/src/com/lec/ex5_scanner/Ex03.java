package com.lec.ex5_scanner;

import java.util.Scanner;

// 이름(톰 크루즈or 홍길동) -> 주소 -> 나이
public class Ex03 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("이름을 입력해주세요 : ");
	String name = scanner.nextLine();
	System.out.println("주소를 입력해주세요 : ");
	String adress = scanner.nextLine(); // nextline의 사용 위치에 주의. 버퍼에 \n이 남아있을 때에 필히사용...
	System.out.println("나이를 입력해주세요 :");
	int age = scanner.nextInt();
	System.out.println(name + "님" + age + "살, " + adress + " 거주");
			
}
}
