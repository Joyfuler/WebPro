package com.lec.ex4_momchild;

public class Child {
	private String name; // (null����)
	static MomPouch momPouch; // (null����)
	 // �켱 mompouch�� �̾����� ������ ������ ��.
	
	public Child (String name) { // �����Լ��� c1 = new Child("ù°") �������� ���� ����.
		this.name = name; // �Ű������� ���� name�� �� ���� �ִ� name ������ ����. ���� ���ʿ� �ִ� name�� ������� ����. 
		// main�� �ƴ� child �޼ҵ忡�� ����?!
		momPouch = new MomPouch(); // mompouch�� null���� money (int) 200��� �����ͷ� �־���.
				
	}
	public void takeMoney (int money) {
		if(momPouch.money >= money) { // ������ ���� ���� �޶�� money���� ũ�ٸ�
			momPouch.money -= money; 
			System.out.println(name + "�� " + money + " �� �������� ���� ������ " + momPouch.money + "�� ������.");
			
		} else {
			System.out.println(name + "�� �� �� ����. ���� ���� ������" + momPouch.money + "�� ����.");
		}
		
		
	}
	
}
