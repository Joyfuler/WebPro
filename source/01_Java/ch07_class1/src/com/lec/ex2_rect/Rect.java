package com.lec.ex2_rect;
// Ŭ���� : �Ӽ� (������, �ν��Ͻ� ����), �޼ҵ� (public), setter&getter) 
public class Rect { // Ŭ�������� �ݵ�� �빮��. ������ �ҹ��ڷ�.. �ĺ���: ���ĺ�, �����, ���ڷ�. ���� ���ĺ����� �����ؾ� ��.)
	private int width; // private ���̺���
	private int height; // ���̺���
	
	// ������ �Լ� �߰� ������ public, class �̸��� ����.
	public Rect() {} //�⺻ ������ �Լ�. (������ �Լ��� ���� ��� �ڵ�����)
	
	public Rect (int width, int height){ // �Ű������� 2�� ���� �����ڸ� ����.
		this.width = width;
		this.height = height;
	}
	// return�� ����.
		
		
	public Rect (int side) { // �Ű������� 1�� �ִ� ������.
	width = height = side; // side�� 7�� �ְ� ���̿� ���̿� ��� 7�� ����. (���簢��)
	}
	
	
	
	
	
	
	public int area() { // �簢���� ���̸� ���ϴ� �޼ҵ�(���)
		return (width * height); // ���̿� ������ ���� ��ȯ��.
		
	}
	// ���Ͱ���
	
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int height) {
		this.height = height;
	
	}
	public int getHeight() {
		return height;
	}
	
}
// �� ���赵