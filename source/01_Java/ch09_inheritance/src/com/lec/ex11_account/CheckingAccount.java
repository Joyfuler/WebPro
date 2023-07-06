package com.lec.ex11_account;

// Account에서 accountNo, ownerName, balance, deposit () withdraw(), infoPrint와 infoString 등을 가져옴.
public class CheckingAccount extends Account {
// 체크카드의 경우 - CheckingAccount이므로 카드번호 추가 + 금액 사용시 잔액이 차감.
// CheckingAccount ca1 = new CheckingAccount ( "111","홍",[1000], "1234123412341234); 식으로 만들 계획.	
	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}

	public CheckingAccount(String accountNo, String ownerName, String cardNo) { // 잔액을 넣지 않는 경우도 있으므로...
		super(accountNo, ownerName);
		this.cardNo = cardNo; // cardNo만 추가한 후 복붙.
	}

	// 객체 이름이 ca1? ca.pay 하면 알아서 카드번호 조회한 후 일치하면 금액빠지도록.
	public void pay(String cardNo, int amount) {
		if (cardNo.equals(this.cardNo)) { // 카드 번호가 일치하는 경우
			if (getBalance() >= amount) {
				// balance 그대로 하면 오류남. setget을 사용해야 함.
				setBalance(getBalance() - amount); // ★ getbalance로 가져온 후 사용된 금액을 다시 set하는 과정.
				System.out.printf("%s님, %d원 지불하여 %s 계좌에 잔액 %d입니다.\n", getOwnerName(), amount, getAccountNo(),
						getBalance()); // 위에서 amount 뺀 잔액이 set 되었고, 그것을 다시 get 하는 과정.
			} else { // 잔액이 부족한 경우
				System.out.println(getOwnerName() + " 님, 잔액이 부족하여 지불할 수 없습니다.");
			}
		} else {// 카드 번호가 잘못된 경우
			System.out.println("유효한 카드 번호가 아닙니다.");
		}
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
