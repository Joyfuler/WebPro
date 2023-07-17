package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerHashMapMain {
	public static void main(String[] args) {
		String name, tel, address;
		HashMap<String, Customer> hashmap = new HashMap<String, Customer>();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("회원 가입을 진행하시겠습니까? (y/n, n을 입력 시 회원 리스트가 출력)");
			String answer = scanner.nextLine();
			if (answer.equalsIgnoreCase("n") && (hashmap.size() != 0)) {
				break; // 바로 아래쪽 회원정보 리스트로 이동.
			} else if (answer.equalsIgnoreCase("n") && (hashmap.isEmpty())) {
				System.out.println("현재 가입한 회원이 없습니다.");
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
		Iterator<String> iterator = hashmap.keySet().iterator(); // unreachable.. 닿지 않는다는 것. if의 조건이 구려서 안 조건문을 못 나와서
																	// 발생하는 오류...
		System.out.println("---------------회원정보 리스트--------------");
		while (iterator.hasNext()) {
			String information = iterator.next();
			System.out.println(hashmap.get(information));

		}
	}
}
