package com.lec.ex02_protected;

public class SuperIJ {
	protected int i; // i=20; ������ �ʱ�ȭ x, �ܺο��� �����͸� �������� ��찡 ��κ��̱� ����.
	private int j; // �ܺο��� ������ ����� ���� ���� ���ٸ� get,set ��� x.. ������ ����°� ����.
	
	public SuperIJ() { // SuperIJ Ŭ������ ���� ����Ʈ �Լ�. ��ӹ��� Ŭ�������� �����ǽ����. SuperIJ();...
					   // ���� ��쿡�� extends�� ������ ChilduIJ.java �� ������.
		System.out.println("�Ű����� ���� SuperIJ ������ �Լ�");
	}

	public SuperIJ(int i, int j) { // i�� j�� ��� ����ϴ� ������ �Լ� �ڵ�����.
		System.out.println("�Ű����� �ִ� SuperIJ ������ �Լ�. i�� j���� �ʱ�ȭ");
		this.i = i;
		this.j = j;
	}

	public int getI() { // get,set �ڵ�����.
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	
	
	
}
