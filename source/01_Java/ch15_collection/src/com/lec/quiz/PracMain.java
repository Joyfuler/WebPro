package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class PracMain {
	public static void main(String[] args) {
		String name, tel, address;
		ArrayList<Customer> customers = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("회원가입을 진행하시겠습니까? (Y/N) ");
		
		String answer = scanner.nextLine();
		if (answer.equalsIgnoreCase("n")) {
			System.out.println("회원 가입을 중지합니다.");
			break;
		}
		System.out.println("당신의 이름을 입력해주세요. :");
		name = scanner.nextLine();
		System.out.println("당신의 전화번호를 입력해주세요. : ");
		tel = scanner.nextLine();
		System.out.println("당신의 주소를 입력해주세요.");
		address = scanner.nextLine();
		System.out.println("가입해 주셔서 감사합니다.");
		customers.add(new Customer(name, tel, address));
		
		}
		if (customers.size() == 0) {
			System.out.println("현재 가입된 회원이 없습니다.");
		} else {
			System.out.println("현재 가입되어 있는 회원 목록입니다.");
			for (Customer customer : customers) {
				System.out.println(customer);
			
			}
		}

	}

}
