package com.lec.ex11_account;

// Account���� accountNo, ownerName, balance, deposit () withdraw(), infoPrint�� infoString ���� ������.
public class CheckingAccount extends Account {
// üũī���� ��� - CheckingAccount�̹Ƿ� ī���ȣ �߰� + �ݾ� ���� �ܾ��� ����.
// CheckingAccount ca1 = new CheckingAccount ( "111","ȫ",[1000], "1234123412341234); ������ ���� ��ȹ.	
	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}

	public CheckingAccount(String accountNo, String ownerName, String cardNo) { // �ܾ��� ���� �ʴ� ��쵵 �����Ƿ�...
		super(accountNo, ownerName);
		this.cardNo = cardNo; // cardNo�� �߰��� �� ����.
	}

	// ��ü �̸��� ca1? ca.pay �ϸ� �˾Ƽ� ī���ȣ ��ȸ�� �� ��ġ�ϸ� �ݾ׺�������.
	public void pay(String cardNo, int amount) {
		if (cardNo.equals(this.cardNo)) { // ī�� ��ȣ�� ��ġ�ϴ� ���
			if (getBalance() >= amount) {
				// balance �״�� �ϸ� ������. setget�� ����ؾ� ��.
				setBalance(getBalance() - amount); // �� getbalance�� ������ �� ���� �ݾ��� �ٽ� set�ϴ� ����.
				System.out.printf("%s��, %d�� �����Ͽ� %s ���¿� �ܾ� %d�Դϴ�.\n", getOwnerName(), amount, getAccountNo(),
						getBalance()); // ������ amount �� �ܾ��� set �Ǿ���, �װ��� �ٽ� get �ϴ� ����.
			} else { // �ܾ��� ������ ���
				System.out.println(getOwnerName() + " ��, �ܾ��� �����Ͽ� ������ �� �����ϴ�.");
			}
		} else {// ī�� ��ȣ�� �߸��� ���
			System.out.println("��ȿ�� ī�� ��ȣ�� �ƴմϴ�.");
		}
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
