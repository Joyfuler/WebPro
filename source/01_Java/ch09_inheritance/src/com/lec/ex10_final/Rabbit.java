package com.lec.ex10_final;
// speed, runnning(), stop(). stop�� �������̵�x
public final class Rabbit extends Animal { // final class ����. ���� rabbit�� �ٸ� ���� ����� ���� ����.
	@Override
	public void running() {
		speed += 30;
		System.out.println("�䳢�� ���ѱ��� �پ��. ���� �ӵ�: " + speed);
	}
	
	
}
