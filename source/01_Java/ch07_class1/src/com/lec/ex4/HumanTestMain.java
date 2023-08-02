package com.lec.ex4;

import com.lec.ex4_human.*; // ��� Ŭ������ import �ϰڴٴ� �ǹ̷�. ������ Woman, Man �� ���پ� �־��..
import com.lec.ex4_human.kid.Kid;

public class HumanTestMain {
	public static void main(String[] args) {
	   Woman woman1 = new Woman();
	   Woman woman2 = new Woman();
	   
	   System.out.println("woman1�� woman2�� ������ ���� : " + (woman1 == woman2));
	   System.out.println("woman1�� woman2�� ������ ���� : "+ woman1.equals(woman2));  // ���� �����Ͱ� �ƴ� ��ü Ÿ���̹Ƿ� �ܼ��� == ���δ� ���� �� ����.
	   											// ���� woman.equals(���) �� ��Ȯ�� ���ϴ� ���� ����. 
	   	Man man = new Man();
	   	Kid kid = new Kid("ȫ�ư�"); // �ణ�� �ٸ��� �� �ٸ� ��Ű���� �����. (human.* �̶� �ؼ� human.kid ��Ű���� ���ԵǴ� ���� �ƴ�)
	   	Kid kid2 = new Kid(); // �⺻ �����ڰ� ���� �����̹Ƿ� �̷� ���¿��� ��ü�� ���� ���� ����.
	   	
	   	Man kim = new Man("ȫ�浿", 21, 178, 60); // �������� double�� �ڵ����������Ƿ� 59.0���� �����.
	   	Man sin = new Man("�ű浿");
	   	Man kim2 = kim;
	   	System.out.println("kim�� kim2�� ������ ���� : " + kim2.equals(kim)); // ���� �ּ��̹Ƿ� true�� ��.
	   	sin.setHeight(177);
	   	sin.setWeight(61);
	   	System.out.println("kim�� BMI ���� :" + kim.calculateBMI());
	   	
}
}
