package com.lec.ex5_scanner;

import java.util.Scanner;

// 나이 - 이름 - 
public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하세요. : "); // nextInt는 데이터 + \n 이 됨. (\n이 강제로 뒤에 붙음). 이후 데이터는 들어가고 \n이 남음.
		int age = scanner.nextInt();
		System.out.println("입력한 나이는 " + age);
		System.out.print("성함을 입력해주세요. : ");
		String name = scanner.next(); // 홍길동(O), 톰크루즈(O), 톰 크루즈 (x). white-space(스페이스,탭,\n) 앞까지 가져옴.
		System.out.println("입력한 이름은 " + name);
		System.out.print("주소를 입력해주세요. :");
		scanner.nextLine(); // 아무것도 하지 않고, 대신 앞에 남아있는 \n을 삭제해주는 역할.
		String address = scanner.nextLine(); // 이 경우 \n 앞부분까지 가져옴. 앞줄에 \n만 남아있는 상태이므로, 아무것도 return되지 않음. 이후 \n을 삭제함.
		System.out.println("입력한 주소는 " + address); // 하지만 톰 크루즈가 짤리는 문제가 발생...
		System.out.println("끝");
		
	}
}
