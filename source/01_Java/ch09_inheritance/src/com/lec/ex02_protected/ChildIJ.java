package com.lec.ex02_protected;

// �����Լ����� ChildIJ child = new ChildIJ(); �� �Ѵٸ�?
public class ChildIJ extends SuperIJ {
	private int total;

	public ChildIJ() { // ��ӹ��� �� �� �Ű����� x ������ �־��!
		System.out.println("�Ű������� ���� ChildIJ�� ������ �Լ�");
		
	}
	public ChildIJ(int i, int j) { // ���Ŭ�����̹Ƿ� ��� i,j�� ���� ����.
		System.out.println("�Ű����� i,j�� �ִ� ChildIJ ������ �Լ�. i,j ���� �ʱ�ȭ");
		// this.i = i; private�� ��� �� ������ ����ϸ� ����. �ٸ� Ŭ�������� ����� �� ���� ����. protected�� �ٲ���.
		this.i=i;
		setJ(j); // setJ�� public�̹Ƿ� ����� ������. setJ�� j ���� �����ϴ� ������� ��ȸ�Ͽ���.
	}
	public void sum() {
		total = i + getJ(); // J�� ������..
		System.out.println("i= " + i + ", j= " + getJ() + ", total =" + total); // J�� ���� private�̹Ƿ� set, get���� �����Ͽ���.
	}
	

}
