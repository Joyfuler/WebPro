package com.lec.ex1_car;
 // Ŭ���� --> ��ü ���� (��ü �ȿ��� �����Ϳ� �޼ҵ尡 �Բ� ����) Car car = new Car ();
public class Car { // 
	private String color; // �÷���� ���� ����
	private int cc; // ��ⷮ ���� ����
	private int speed; // ���� �ӵ� ���� ���� //
	// 3���� �����͸� ������ ��. ���� private�� �־� �ܺο��� �����͸� �ٲ��� ���ϰ� ����.
	
	public void park() { // �������
		speed = 0;
		System.out.println(color + "�� �� ������. ���� �ӵ��� " + speed);
		// �ٸ� ������ car.park(); �Է½� ���ǵ�� 0 ������ �� �޼ҵ� ���
	}
	
	public void drive() { // �������϶��� �޼ҵ带 ����
		speed = 60;
		System.out.println(color + "�� �� ������. ���� �ӵ��� " + speed);
	}
	
	public void race() { //���� ���
		speed = 120;
		System.out.println(color + "�� �� ���̽�. ���� �ӵ��� " + speed);
	}
		// �����͸� ���� �ְ�, �� �� ���(���ǵ� ���� ����, ���)�ϴ� �Լ��� �Բ� �־���.
		
		// color, cc, speed�� ��� private�� �־ �ٸ� Ŭ�������� ������� ���ϰ� �Ǿ����. �� �� setter & getter �޼ҵ尡 �ʿ���.
	public void setColor(String color) {
		this.color = color; // (this�� �־� �Ű������� ���� color�� ��ü�� �ִ� color�� �ְ� ��. (color�� �ߺ��Ǿ� �ֱ� ����)
		
	}
	public String getColor() {// ���� getter �޼ҵ带 �־���.	
		return color;
		
	}	
	
	
	public void setCc (int cc) {
		this.cc = cc; // (���������� �Ű����� cc�� ��ü�� �ִ� cc�� �ְ� ����.)
		
	}

	public int getCc() {
		return cc;
	
	
	}
	
	public void setSpeed (int speed) {
		this.speed = speed;
	}
	
	public int getSpeed () {
		return speed;
	}
}
