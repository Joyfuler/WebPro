package com.lec.ex02_store;
// �߻� Ŭ����: �߻� �޼ҵ�(���� �� �޼ҵ�)�� 1�� �̻� �ִ� ��� class �տ� abstract�� �ٿ� ���� Ŭ����.

// ��ӹ��� Ŭ������ �������̵带 ����.
// �� ���ĸ޴��� ������ �ʵ���...

public interface HeadQuarterStore { // �߻�Ŭ������ �ִ� ���� class �տ��� abstract�� ���ϰ�

	public void kimchi();
	// ��� �޴��� ���� �������̵� �ؾ��Ѵٸ�?
	// �ݵ�� �������̵� �ϵ��� �� �� ����. --> kimchi��� �޼ҵ带 ���� �� �� (); �� ������...
	public void bude();
	public void bibim();
	public void sunde();
	public void gonggi();
	public String getStorename();
}
