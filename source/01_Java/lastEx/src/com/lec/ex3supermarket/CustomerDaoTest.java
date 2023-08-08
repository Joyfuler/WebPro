package com.lec.ex3supermarket;

import java.util.ArrayList;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		int result;
		ArrayList<CustomerDto> customers;
		System.out.println("1번 회원가입테스트");
		String ctel = "010-3535-5555";
		String cname = "윤길동";
		result = dao.insertCustomer(ctel, cname); // 성공or실패이므로
		System.out.println(result == CustomerDao.SUCCESS ? cname + "님 회원가입감사. 포인트 1000점 부여" : cname + "님 가입실패");

		System.out.println("2번 전화번호검색테스트");
		ctel = "010-9999-9999";
		customers = dao.ctelGetCustomers(ctel);
		if (customers.isEmpty()) {
			System.out.println("검색하신 전화번호에 해당하는 회원이 없습니다.");
		} else {
			System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적\t고객레벨\t레벨업경험치");
			for (CustomerDto customerDto : customers) {
				System.out.println(customerDto);
			}
			System.out.println("총 인원수는 " + customers.size() + "명");
		}

		System.out.println("3번 물건사기테스트");
		int cid = 4;
		if (dao.getCustomer(cid) == null) { // 해당회원이 있어야만 물품구매가능
			System.out.println(cid +"에 해당하는 회원이 없어 구매를 진행할 수 없습니다.");
		} else {
			int price = 500000;
			result = dao.buy(cid, price);
			if (result == CustomerDao.SUCCESS) {
				System.out.println("물품구매성공. 고객님의 정보가 아래와 같이 업데이트되었습니다.");
				System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적\t고객레벨\t레벨업경험치");
				System.out.println(dao.getCustomer(cid));								
			} else {
				System.out.println("물품구매실패");
			}
		}
		
		System.out.println("4번 레벨별출력");
		customers = dao.levelNameGetCustomers("VVIP");
		if (customers.size() ==0) {
			System.out.println("해당레벨의 회원이 없습니다.");			
		} else {
			System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적\t고객레벨\t레벨업경험치");
			for (CustomerDto customerDto : customers) {
				System.out.println(customerDto);				
			}
		}
		
		System.out.println("5번 전체출력");
		customers = dao.Getcustomers();
		if (customers.size() ==0) {
			System.out.println("해당레벨의 회원이 없습니다.");			
		} else {
			System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적\t고객레벨\t레벨업경험치");
			for (CustomerDto customerDto : customers) {
				System.out.println(customerDto);
			}
		}
		
		System.out.println("6번 회원탈퇴");
		result = dao.deleteCustomer("010-9999-9999");
		System.out.println(result == CustomerDao.SUCCESS? "삭제성공": "유효한 번호가 아닙니다.");
		
	}
}