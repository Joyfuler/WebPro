package com.lec.ex3_math;

import java.util.Random;

// �����߻� ���� --> Math.random() ���. 0���� 1������ �����Ǽ��߻�.
// ex���������� - (int)(Math.random() *3) �������������� ��..
public class Ex03_random {
	public static void main(String[] args) {
		System.out.println("1���� 45������ ���� ������ �߻���Ű�� �����? : " + ((int)(Math.random()* 45) +1));
		// +1�� �ؾ��ϰ�, int ����ȯ�� �ؾ��ϰ�, ��ȣ�� ���Ƽ� �ſ� ���ŷο�..
		System.out.println("0���� 2������ ���� ������ �߻���Ű�� �����? : " + (int)(Math.random()*3));
		// ������ ������ ���� ����� ���!
		Random random = new Random();
		System.out.println("������ ������ �߻���Ű�� �����? " + random.nextInt()); // -21�￡�� +21�� ����.
		System.out.println("double�� ������ �߻����� : " + random.nextDouble());
		System.out.println("true,false�� ������ ���� : " + random.nextBoolean()); //true�� false�� ��������..
		System.out.println("Ư�� ���� ���� ���� �߻���? (0~100) : " + random.nextInt(101)); // 101�� �Է½�, 0���� 100����.
		System.out.println("0~2 ������ ���� �߻� �����? : " + random.nextInt(3));
		System.out.println("1~45������ ���� ���� �߻� �����? :" + (random.nextInt(45) +1));
	}
	
}
