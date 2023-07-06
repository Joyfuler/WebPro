package com.lec.ex11_account;

// CheckingAccount 에서 accountNo, ownerName, balance, deposit () withdraw(), infoPrint와 infoString 등을 가져옴.
public class CreditLineAccount extends CheckingAccount {

	// 신용카드이므로 여기에 한도를 추가해야함.
	private int creditLine; // 카드한도

	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine; // 매개변수로 받은 한도가~

	}

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine; // 매개변수로 받은 한도가~
		
	}

	// 또한 신용카드는 pay시 잔액이 아닌 한도에서 빠지니 오버라이드를 해서 고쳐야함.
// ca.pay ("카드번호", 금액)
	@Override
	public void pay(String cardNo, int amount) {
		if (cardNo.equals(getCardNo())) { // 카드 번호가 일치하는 경우
			if (creditLine >= amount) {
				// balance 그대로 하면 오류남. setget을 사용해야 함.
				creditLine -= amount; // ★ getbalance로 가져온 후 사용된 금액을 다시 set하는 과정.
				System.out.printf("%s님, %d원 지불하여 한도 %d원 남았습니다.\n", getOwnerName(), amount, creditLine);
						// 위에서 amount 뺀 잔액이 set 되었고, 그것을 다시 get 하는 과정.
			} else { // 잔액이 부족한 경우
				System.out.println(getOwnerName() + " 님, 한도가 부족하여 지불할 수 없습니다.");
			}
		} else {// 카드 번호가 잘못된 경우
			System.out.println("유효한 카드 번호가 아닙니다.");
		}
	}
	
	

}
