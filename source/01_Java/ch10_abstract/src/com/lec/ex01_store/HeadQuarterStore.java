package com.lec.ex01_store;
// �߻� Ŭ����: �߻� �޼ҵ�(���� �� �޼ҵ�)�� 1�� �̻� �ִ� ��� class �տ� abstract�� �ٿ� ���� Ŭ����.
// ��ӹ��� Ŭ������ �������̵带 ����.
// �� ���ĸ޴��� ������ �ʵ���...

public abstract class HeadQuarterStore { // �߻�Ŭ������ �ִ� ���� class �տ��� abstract�� ���ϰ�
	private String storename;

		

	public HeadQuarterStore(String storename) {
		this.storename = storename;
	}
	public abstract void kimchi(); 
	// ��� �޴��� ���� �������̵� �ؾ��Ѵٸ�?
	// �ݵ�� �������̵� �ϵ��� �� �� ����. --> kimchi��� �޼ҵ带 ���� �� �� (); �� ������... 
	
	public abstract void bude();
	public abstract void bibim ();
	public abstract void sunde();
	public abstract void gonggi();
	public String getStorename() {
		return storename;
	}
}
