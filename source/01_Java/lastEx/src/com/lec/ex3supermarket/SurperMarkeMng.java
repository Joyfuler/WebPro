package com.lec.ex3supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SurperMarkeMng {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		Scanner scanner = new Scanner(System.in);
		String fn; // 고객이 입력하는 값
		ArrayList<CustomerDto> customers; // 해당 클래스의 각종 배열객체들을 소환가능

		do {
			System.out.println("1:회원가입 2:폰검색 3:물품구입 4:레벨별출력 5:전체출력 6:회원탈퇴 기타:종료");
			fn = scanner.next();
			switch (fn) {
			case "1":
				System.out.print("가입할 회원 핸드폰번호는?");
				String ctel = scanner.next();
				System.out.print("가입할 회원이름은?");
				String cname = scanner.next();
				int result = dao.insertCustomer(ctel, cname);
				System.out.println(result == CustomerDao.SUCCESS ? "가입성공" : "가입실패");
				break;

			case "2":
				System.out.println("검색할 전화번호 4자리, or 전화번호 전체 입력해주세요");
				String searchTel = scanner.next();
				customers = dao.ctelGetCustomers(searchTel);
				if (customers.isEmpty()) {
					System.out.println("해당하는 전화번호 회원이 없습니다.");
				} else {
					System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적\t고객레벨\t레벨업경험치");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
					System.out.println("해당하는 회원수 :" + customers.size() + "명");
				}

				break;
			case "3":
				System.out.print("구매할 고객id를 입력하세요. (아이디가 잘못입력될경우구매불가)");
				int cid = scanner.nextInt();
				if (dao.getCustomer(cid) == null) {
					System.out.println("해당 id의 고객이 없습니다.");
				} else {
					System.out.print("구매금액은? ");
					int price = scanner.nextInt();
					result = dao.buy(cid, price);
					if (result == CustomerDao.SUCCESS) {
						System.out.println("물품구매 감사합니다." + price + "원 구매 후 고객님 정보가 업데이트 되었습니다.");
						System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적\t고객레벨\t레벨업경험치");
						System.out.println(dao.getCustomer(cid));
					}
				}
				break;
			case "4":
				System.out.print("검색하고자 하는 등급명은?" + dao.getLevelNames());
				String levelName = scanner.next();
				customers = dao.levelNameGetCustomers(levelName);
				if (customers.isEmpty()) {
					System.out.println("해당등급의 고객이 없습니다.");
				} else {
					System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적\t고객레벨\t레벨업경험치");
					for (CustomerDto customerDto : customers) {
						System.out.println(customerDto);
					}
				}
				break;
			case "5":
				customers = dao.Getcustomers();
				if (customers.isEmpty()) {
					System.out.println("해당등급의 고객이 없습니다.");
				} else {
					System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적\t고객레벨\t레벨업경험치");
					for (CustomerDto customerDto : customers) {
						System.out.println(customerDto);
					}
				}
				

				break;
			case "6":
				System.out.println("탈퇴할 전화번호는?");
				ctel = scanner.next();
				result = dao.deleteCustomer(ctel);
				System.out.println(result == CustomerDao.SUCCESS? "삭제성공" :"삭제실패");

				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3") || fn.equals("4") || fn.equals("5")
				|| fn.equals("6"));
		System.out.println("終了");
	}

}
