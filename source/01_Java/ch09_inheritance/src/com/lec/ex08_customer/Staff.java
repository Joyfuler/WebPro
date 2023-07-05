package com.lec.ex08_customer;
// person�� name, tel, infostring�� ����. 
// ���� �����Ͷ��? �Ի���..
public class Staff extends Person {
	private String hiredate; // �Ի��� ("2020-12-01") ������.. ���� date�� �Է�
	private String department; // �μ���. ȸ���, ������...
	// Staff s = new Staff("ȫ���", "9999-9999", "2023-01-01", "����" ������ �Է��� ����. �տ��� �θ�Ŭ������!)
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}
	@Override
	public String infoString() {
		return super.infoString() + "[�Ի���] " + hiredate + "[�μ�]" + department; 
		//�������� person�� ��Ƽ� infostring�� Ȱ���Ͽ���.
	}

}
