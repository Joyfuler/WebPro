package com.lec.ex08_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("홍고객", "010-9999-9999", "서울", "12-01"); //customer 객체를 선언하고 바로 정보입력
		System.out.println(customer.infoString()); // 현재 가입만 했을때의 고객정보
		customer.buy(500000); // 50만원어치 구매
		customer.buy(710000);
		
		Staff staff = new Staff("홍사원", "010-8888-8888", "2023-07-04", "전산");
		// staff과 customer 모두 가지고 있는 정보를 배열화. 이름, 전번 등...
		Person [] person = {customer, staff};
		for (int idx = 0; idx<person.length; idx++) { // idx는 이름과 전화번호밖에 없으므로 길이는 2
			System.out.println(person[idx].infoString()); // 해당 인원의 이름, 전화번호 등등 정보를 한번에출력
		}
		
		System.out.println("-------------------------");
		for (Person p : person) {
			System.out.println(p.infoString()); // idx를 따로 봐서 중간에 무언가를 출력해야 한다면 일반, 그냥 처음부터 끝까지 출력이 가능하다면 확장for문을 사용
		}
	}
}
