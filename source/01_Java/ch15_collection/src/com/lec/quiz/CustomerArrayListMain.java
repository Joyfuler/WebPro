package com.lec.quiz;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
// N을 입력할 때까지 고객 이름, 전화, 주소를 입력받아 arraylist add
// N을 입력하면 arraylist for문을 출력함. arraylist.size(); == 0 이라면 출력 ㄴㄴ
import java.util.Scanner;

public class CustomerArrayListMain {
	public static void main(String[] args) {
		String name, tel, address;
		ArrayList<Customer> customers = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("회원 가입을 진행하겠습니까? (Y/N) - N 입력시 회원 리스트를 출력합니다.  : ");
			String answer = scanner.nextLine().trim();
			if (answer.equalsIgnoreCase("n") && customers.size()!=0) {
				break;
			}else if(answer.equalsIgnoreCase("n") && customers.size()==0) {
				System.out.println("가입 한번 이라도 안 하면 안 끝나");
			}

			System.out.println("당신의 이름을 입력해주세요. : ");
			name = scanner.nextLine();
			System.out.println("당신의 전화번호를 입력해주세요. : ");
			tel = scanner.nextLine();
			System.out.println("당신의 주소를 입력해주세요 : ");
			address = scanner.nextLine();
			customers.add(new Customer(name, tel, address)); // Customer 객체로 만들어야 하므로, new customer() 를 사용해 감싸자.

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
