package com.lec.ex02_protected;

public class ChildIJtestMain {

	public static void main(String[] args) {
		ChildIJ child1 = new ChildIJ();
		child1.setI(1); 
		child1.setJ(2); // i�� j�� ���� ���� 1,2�� set ���־���. ChildIJ�� �ö󰡼� ���.
		child1.sum(); // ChildIJ�� i+j�� ����ִ� sum �޼ҵ带 �����Ͽ���.
		
		System.out.println("-----------------");
		
		ChildIJ child2 = new ChildIJ(10,20); // i�� j�� ���� ����. �׷��� �θ�Ŭ�������� i,j�� �̽��� ���� ����..
		// ���� ���. �ϳ��� SuperIJ ������, �ϳ��� CHildIJ �����Ͱ� ��µ� ��.
		// �θ�Ŭ������ ���� ������ �Ű������� ���� ���� ��µ�. �ڽ�Ŭ�������� ���������� 10,20 �Ű����� 2���� ���ԵǾ���.
		child2.sum();
	}

}
