package com.lec.ex08_customer;

import cons.Constant;

// name, tel, / infoString() 등의 정보 보유
public class Customer extends Person {
	private String address; // Person에 없는 고객만의 데이터들.
	private int sum; // 여태까지 구매했던 금액의 누적합계
	private int point; // 구매한 금액의 일정 부분( 0.5%) 을 포인트로 자동적립
	private String date; // 생년월일 등 정보. (String? 추후 Date사용..)
	private boolean vip; // vip 고객인지 아닌지의 여부..일반고객은 false, vip고객은 true

	// 생성자 생성...
	// Customer c = new Customer("홍길동", "9999-9999", "서울", "07-05")...
	// 구매금액 및 포인트는 생성자에서 입력 x, 외부에서 입력해서 변해야...
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);
		this.address = address; // 외부에서 들어온 주소가 이 값으로.
		this.date = date; // 외부에서 들어온 생년월일 정보가 이 값으로.
		point = 1000; // 회원가입시 포인트는 1000으로 시작.
		sum = 0; // 최초 사용시에는 0으로 시작...
		System.out.println(name + " 님, 가입 감사합니다. 포인트 1,000점 넣어 드렸습니다.");
	}

	public void buy(int price) { // 얼마나 구매했는지. c.buy(10000); 이후 얼마나 적립되는지... c라는 사람이 이미 10만원 이상 구매했다면 vip 등재...
		// 구매금액 누적
		sum += price; // 구매 누적금액이 됨.
		int thisPoint = (int)(price * Constant.RATE); // 이번 구매로 받은 포인트. int로 소숫점 자체를 버림..
		point += thisPoint; // 포인트도 계속 적립해야...
		System.out.println(getName() + "님 구매 감사. 금번 구매로  포인트는" + thisPoint + "입니다. 총 누적 포인트는" + point ); // 감사문구
		System.out.println("총 구매금액은 : " + price);
		if (vip==false && sum>=Constant.VIPLIMIT) { // VIPLIMIT로 설정한 가격을 넘고 vip도 아직 아니라면?
			System.out.println("VIP 고객으로 업그레이드 되셨습니다. 자주 뵙겠습니다."); // vip라면 해당 문구는 출력x
		} //if
		
		
		// 포인트 0.5% 누적.. 역시 누적이 너무 많이 되면 수치를 자주변경해줘야...
		// 감사문구 출력..
		// vip 고객이 아닐 경우, VIPLIMIT 이상 구매 누적 금액일 경우 vip=true로 변경... (vip의 limit치 등 자주 변경해 주어야)
		// 한다면 따로 뺄것...
	} //buy
	
	@Override
	public String infoString() { //infostring을 오버라이드 하고싶다면, 메소드 이름을 입력한 후 컨트롤 스페이스
		// TODO Auto-generated method stub
		return super.infoString() + "[주소] " + address + " [포인트] " + point + " [구매누적] " + sum + " [고객등급] "
		+ (vip==true? "VIP" : "일반"); // person에는 이름 , 전화만 있음. 여기에 주소, 포인트, 고객등급까지 출력...
	}
} // class
