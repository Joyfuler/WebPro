package com.lec.ex11_account;

// CheckingAccount ���� accountNo, ownerName, balance, deposit () withdraw(), infoPrint�� infoString ���� ������.
public class CreditLineAccount extends CheckingAccount {

	// �ſ�ī���̹Ƿ� ���⿡ �ѵ��� �߰��ؾ���.
	private int creditLine; // ī���ѵ�

	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine; // �Ű������� ���� �ѵ���~

	}

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine; // �Ű������� ���� �ѵ���~
		
	}

	// ���� �ſ�ī��� pay�� �ܾ��� �ƴ� �ѵ����� ������ �������̵带 �ؼ� ���ľ���.
// ca.pay ("ī���ȣ", �ݾ�)
	@Override
	public void pay(String cardNo, int amount) {
		if (cardNo.equals(getCardNo())) { // ī�� ��ȣ�� ��ġ�ϴ� ���
			if (creditLine >= amount) {
				// balance �״�� �ϸ� ������. setget�� ����ؾ� ��.
				creditLine -= amount; // �� getbalance�� ������ �� ���� �ݾ��� �ٽ� set�ϴ� ����.
				System.out.printf("%s��, %d�� �����Ͽ� �ѵ� %d�� ���ҽ��ϴ�.\n", getOwnerName(), amount, creditLine);
						// ������ amount �� �ܾ��� set �Ǿ���, �װ��� �ٽ� get �ϴ� ����.
			} else { // �ܾ��� ������ ���
				System.out.println(getOwnerName() + " ��, �ѵ��� �����Ͽ� ������ �� �����ϴ�.");
			}
		} else {// ī�� ��ȣ�� �߸��� ���
			System.out.println("��ȿ�� ī�� ��ȣ�� �ƴմϴ�.");
		}
	}
	
	

}
