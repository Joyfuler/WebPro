package com.lec.ex1_car;

import java.io.ObjectInputStream.GetField;

public class CarMain {
	public static void main(String[] args) {
		int i; // �ش� �����Ͱ� ���� ����.
		String name = "ȫ"; // �ش� �������� �������� ���� (�� ������ �빮��)
		Car myPorsche = new Car();

		// ������������� ������ ����. String�� ���������� �ش� �ּҰ� ����Ǵ� ��.
		// car��� Ŭ������ �ִ� �÷�, cc, speed, park, drive, race �� �����͸� ��� �ҷ���.

		// int[] arr = new int[3]; ������ ���� ����� ��� {0,0,0} ���� �ʱ�ȭ��.
		// ��ü �������� ��� ���̵����Ͱ� ������ �ʰ� 000���� �����͸� û����.
		// ���������� new Car(); �� �ҷ����� ��� string�� null, int�� 0���� �ʱ�ȭ��.

		// myPorsche.color = "����"; // private �ְ� getset���� �Ķ��?
		myPorsche.setColor("����");

		// myPorsche.cc = 3000;
		myPorsche.setCc(3000);
		
		// System.out.println(myPorsche.color + "�� �� : " + myPorsche.cc + "cc, �ӵ�: " + myPorsche.speed);
		System.out.println(myPorsche.getColor() + "�� �� : " + myPorsche.getCc() + "CC, �ӵ� : " + myPorsche.getSpeed());
		// private�� ��쿣 set�ؼ� ���� �����ϰ�, get���� return���� ���� �� ���ο��� getcolor() �������� �ҷ��� �� ����.
	

		// myporsche�� speed�� �ƹ��͵� �������� �ʾұ⿡ speed�� 0�� ��µ�.

		myPorsche.drive(); // ����̺�, 60���� car �޼ҵ忡�� ������ ����.
		System.out.println("--------------");
		myPorsche.race(); // ���̽�, 120���� �����.

		Car yourPorsche = new Car(); // yourPorche��� ���ο� ��������. (car Ŭ������ ������)

		System.out.println("--------------");
		yourPorsche.setColor("�׷���");
		yourPorsche.setCc(5000); // color�� null -> �׷��̷�, drive�� �־����� �ӵ��� 0 -> 60����.
		System.out.println("���� ���� �������� cc�� ���� : " + yourPorsche.getCc());
		// ��, �� �������� yourPorche�� �� ���� myPorche�� ������ ���� ����. ��ó�� �ٲ㵵 myPorche ���� �״��
		// myPorsche.drive(); �� ������ ������ ���� �����ߴ� �������� ����. �̸� �ν��Ͻ� ������� ��.

	}

}
