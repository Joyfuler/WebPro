package com.lec.ex04_shape;

public abstract class Shape { // ���� �߻�. abstract ������
// ��, �簢��, �ﰢ��... ����� �����Ͱ� ���� ���?
// ���̸� ����ϴ� area
	public abstract double area(); // ���̸� return�� �߻�޼ҵ带 ����. ���� ��ӽ� �������̵尭��
	public void draw() {
		System.out.println(" ������ �׷���");
	}
}
