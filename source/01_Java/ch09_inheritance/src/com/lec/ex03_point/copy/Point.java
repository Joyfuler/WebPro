package com.lec.ex03_point.copy;
// 2���� ��ǥ��
public class Point {
	private int x;
	private int y;
	
	public Point() { // �ʼ������� �Ű�����x ������ ���� ����!
		System.out.println("�Ű������� ���� �θ�Ŭ���� ������ �Լ�");
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("�Ű����� 2���� �ִ� �θ�Ŭ���� ������ �Լ� - x,y �ʱ�ȭ");
	}
	
	public void infoPrint() {
		System.out.println("��ǥ�� : x = " + x + ", y = " + y);
	}

	public int getX() { // x,y�� ��� private�̹Ƿ� �ܺο��� �ְų� ����� �� �ֵ��� get,set�� �����ص�.
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
