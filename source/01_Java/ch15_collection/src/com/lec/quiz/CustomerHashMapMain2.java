package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerHashMapMain2 {
	public static void main(String[] args) {
		String name;
		String tel;
		String address;
		HashMap<String, Customer> hashmap = new HashMap<String, Customer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("회원 가입을 진행하시겠습니까? (y/n, n을 입력 시 회원 리스트가 출력)");
		String answer = scanner.nextLine();
		while (true) {
			if (answer.equalsIgnoreCase("x") && hashmap.size() != 0) {
				break;
			} else if (answer.equalsIgnoreCase("x") && hashmap.size() == 0) {
				System.out.println("현재 회원이 없습니다.");
				continue;
			} else if (answer.equalsIgnoreCase("y")) {
								System.out.print("당신의 이름을 입력해주세요.");
				name = scanner.nextLine();
				System.out.print("당신의 전화번호를 입력해주세요.");
				tel = scanner.nextLine();
				System.out.print("당신의 주소를 입력해주세요.");
				address = scanner.nextLine();
				hashmap.put(tel, new Customer(name, tel, address));
			}
			}
		}

	}


