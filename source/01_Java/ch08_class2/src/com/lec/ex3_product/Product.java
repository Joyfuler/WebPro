package com.lec.ex3_product;
// ��� ��ǰ���� �ø��� �ѹ� �����Ͱ� �ٸ��� ����� ���� ���.
// ���� �޼ҵ忡�� Product p = new Product(1); ... ���⿡ count�� �ִ´ٰų� �̷������� ���� ������ ��������?
// �˾Ƽ� ��ü ��� ��������� �������ִ°� ������..
public class Product {
	private int serialNo;
	public static int count = 100; // static�� �� count �Լ�.. Product��� �޼ҵ�� ������ count (100) ��� �Ű������� ���� �޸𸮿� ����.
								// �� ��ü�� ��� ������ �����ϰ� ��.
	
	public Product() {
		serialNo = ++count; // ��ü�� ���� ������ ������ ���� �־�� �ϴ� ��� static�� �����.
		// ++count�� �ؾ� 101�� �Ǿ����� �ø���ѹ��� 101�� ��.
	}
	
	
	public static void staticMethod() {
		//�Ϲ� �޼ҵ��� ��� ��ü�� ������ �޸𸮿� ���������,
		// ����ƽ �޼ҵ��� ���� �׳� �޸𸮿� ���簡 ������.
		System.out.println("static �޼ҵ�");
	}
	
	
	public void infoPrint() {
		System.out.println("�ø��� �ѹ��� :" + serialNo + "\t �������� count : " + count);
	}

	//getter, setter serialNo ����. count�� ���� static�̹Ƿ� getset�� �̿����� �ʾƵ� ��밡��.
	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
	
	
	
}
