package com.lec.ex2_rect;

public class RectTest {
	public static void main(String[] args) {
	Rect r1 = new Rect(3,5); // int width ������ ��ġ�� �ʱ�ȭ�ϴ� ������ �����ٸ�?
	// test�� �Ű����� 2�� (int width, int height) �־ �����ڸ� �־���. ���� rect() ��ȣ �ȿ� ���ڸ� ���� �־�����.
		
	Rect r2 = new Rect(7); // �Ű����� 1�� �����ϴ� ��. width = height = side;
	Rect r3 = new Rect(); // �Ű������� ���� ���� �����ϴ�. �� ���� ����Ʈ ������ �Լ��� ��.
	System.out.println("r1: " + r1.getWidth() + "*" + r1.getHeight());
	System.out.println("r2: " + r2.getWidth() + "*" + r2.getHeight());
	
	
	System.out.println("r1�� ���̴�: " + r1.area()); //0���� ��µ�.
	System.out.println("r2�� ���̴�: " + r2.area());
	r1.setHeight(10);
	r1.setWidth(50);
	// System.out.println("�簢���� ���̴�: " + r1.getHeight() * r1.getWidth());
	System.out.println("set�� ���� ����. ���� 10 ���� 50�� ��� r1�� ���̴�" + r1.area());
	
	// r3�� ����Ʈ�̹Ƿ� ����, ���� ��� 0���� �Ǿ� ����.
	r3.setWidth(10);
	System.out.println("r3 :" + r3.getHeight() +"*"+
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			r3.getWidth());
	System.out.println("r3�� ���̴�" + r3.area());
	}

}
