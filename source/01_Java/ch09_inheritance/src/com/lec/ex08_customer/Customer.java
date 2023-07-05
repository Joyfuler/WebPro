package com.lec.ex08_customer;

import cons.Constant;

// name, tel, / infoString() ���� ���� ����
public class Customer extends Person {
	private String address; // Person�� ���� ������ �����͵�.
	private int sum; // ���±��� �����ߴ� �ݾ��� �����հ�
	private int point; // ������ �ݾ��� ���� �κ�( 0.5%) �� ����Ʈ�� �ڵ�����
	private String date; // ������� �� ����. (String? ���� Date���..)
	private boolean vip; // vip ������ �ƴ����� ����..�Ϲݰ��� false, vip���� true

	// ������ ����...
	// Customer c = new Customer("ȫ�浿", "9999-9999", "����", "07-05")...
	// ���űݾ� �� ����Ʈ�� �����ڿ��� �Է� x, �ܺο��� �Է��ؼ� ���ؾ�...
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);
		this.address = address; // �ܺο��� ���� �ּҰ� �� ������.
		this.date = date; // �ܺο��� ���� ������� ������ �� ������.
		point = 1000; // ȸ�����Խ� ����Ʈ�� 1000���� ����.
		sum = 0; // ���� ���ÿ��� 0���� ����...
		System.out.println(name + " ��, ���� �����մϴ�. ����Ʈ 1,000�� �־� ��Ƚ��ϴ�.");
	}

	public void buy(int price) { // �󸶳� �����ߴ���. c.buy(10000); ���� �󸶳� �����Ǵ���... c��� ����� �̹� 10���� �̻� �����ߴٸ� vip ����...
		// ���űݾ� ����
		sum += price; // ���� �����ݾ��� ��.
		int thisPoint = (int)(price * Constant.RATE); // �̹� ���ŷ� ���� ����Ʈ. int�� �Ҽ��� ��ü�� ����..
		point += thisPoint; // ����Ʈ�� ��� �����ؾ�...
		System.out.println(getName() + "�� ���� ����. �ݹ� ���ŷ�  ����Ʈ��" + thisPoint + "�Դϴ�. �� ���� ����Ʈ��" + point ); // ���繮��
		System.out.println("�� ���űݾ��� : " + price);
		if (vip==false && sum>=Constant.VIPLIMIT) { // VIPLIMIT�� ������ ������ �Ѱ� vip�� ���� �ƴ϶��?
			System.out.println("VIP ������ ���׷��̵� �Ǽ̽��ϴ�. ���� �˰ڽ��ϴ�."); // vip��� �ش� ������ ���x
		} //if
		
		
		// ����Ʈ 0.5% ����.. ���� ������ �ʹ� ���� �Ǹ� ��ġ�� ���ֺ��������...
		// ���繮�� ���..
		// vip ���� �ƴ� ���, VIPLIMIT �̻� ���� ���� �ݾ��� ��� vip=true�� ����... (vip�� limitġ �� ���� ������ �־��)
		// �Ѵٸ� ���� ����...
	} //buy
	
	@Override
	public String infoString() { //infostring�� �������̵� �ϰ�ʹٸ�, �޼ҵ� �̸��� �Է��� �� ��Ʈ�� �����̽�
		// TODO Auto-generated method stub
		return super.infoString() + "[�ּ�] " + address + " [����Ʈ] " + point + " [���Ŵ���] " + sum + " [�����] "
		+ (vip==true? "VIP" : "�Ϲ�"); // person���� �̸� , ��ȭ�� ����. ���⿡ �ּ�, ����Ʈ, ����ޱ��� ���...
	}
} // class
