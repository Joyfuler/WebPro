package com.lec.ex3_product;

public class ProductTestMain {

	public static void main(String[] args) {
		System.out.println("����ƽ ������ :" + Product.count);
		//
		Product.staticMethod(); // ���� ��ü�� ����ų� ����  �ʾƵ� �ٷ� �����. static�̶� ������� �ǹ�.
		Product p1 = new Product(); // ��ü�� ����� ��� = static�� �ִ� �޸𸮵� p1�� �Բ� ��.
		p1.infoPrint(); // �ø��� �ѹ��� �������� count�� ����� ����.
		Product p2 = new Product(); // static�� �ִ� �޸� (p1�� �ִ� ���� ī��Ʈ)�� p2�� ��. (p2�� �Ҵ�� Product �޼ҵ� + static �޼ҵ�)
		System.out.println("static ���� :" + Product.count); // count�� +1�� �Ǿ����Ƿ�  (102�� ����)
		p2.infoPrint(); // ��� 101+1 �� �Ǿ� 102�� �����.
		new Product(); // ������ ������ �̾ ������ ���� �� ����.
		System.out.println("static ���� :" + p1.count);
		System.out.println("static ���� :" + p2.count);
		
		// ���� static�� �ټ��� �Ű������� �����ϴ� ��������. �޸� �������� �����Ƿ� 1������ �� ��. ������ ���� ��� �ӵ��� �ſ� ������...     
		
		
	}
}
