package com.lec.ex10_final;
// speed, running(), stop() �� dog���� ����. running()�� dog���� �������̵��� speed +=10 �� ����. stop�� ������ �������̵� ����.
public class BlueDog extends Dog {
	@Override
	public void running() {
		speed += 10;
		System.out.println("�Ķ� �������� ������ ���� �پ��. ���� �ӵ� : " + speed);
}
}
