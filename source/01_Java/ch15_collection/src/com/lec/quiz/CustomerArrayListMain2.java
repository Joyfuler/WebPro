package com.lec.quiz;

import java.util.ArrayList;
// N을 입력할 때까지 고객 이름, 전화, 주소를 입력받아 arraylist add
// N을 입력하면 arraylist for문을 출력함. arraylist.size(); == 0 이라면 출력 ㄴㄴ
import java.util.Scanner;

public class CustomerArrayListMain2 {
	public static void main(String[] args) {
		String name, tel, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("회원 가입을 진행하겠습니까? (Y/N) - N 입력시 회원 리스트를 출력합니다.  : ");
			String answer = scanner.nextLine().trim();
			if (answer.equalsIgnoreCase("n") && customers.size()!=0) {
				break;
			}else if(answer.equalsIgnoreCase("n") && customers.size()==0) {
				System.out.println("가입 한번 이라도 안 하면 안 끝나");
			}

		Customer customer = new Customer(); // customer.name = null tel= null address = null. 매개변수 x
		System.out.println("당신의 이름은?");
		customer.setName(scanner.nextLine()); // name이라는 변수 없이 받은 이름을 바로 매개변수로 set함.
		System.out.println("당신의 이름은?");
		customer.setTel(scanner.nextLine()); // name이라는 변수 없이 받은 이름을 바로 매개변수로 set함.
		System.out.println("당신의 주소는?");
		customer.setAddress(scanner.nextLine()); 
		customers.add(customer); // 각 값을 customers라는 배열에 하나씩 추가
		}
		if (customers.size() == 0) {
			System.out.println("가입한 회원이 없습니다.");
		} else {
			for (Customer customer : customers) {
				System.out.println(customer);
			} // for
		} // if
	}
}
