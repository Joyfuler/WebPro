package com.lec.ex01_store;
// �δ�� 8õ��, ���뱹 ���Ⱦ�
public class StoreNum1 extends HeadQuarterStore {

	public StoreNum1(String storename) {
		super(storename); // �������� ����Ŭ���ؼ� ������ �ִ°����� �ٷ� �������ֱ�
		
	} 
	
	@Override
	public void kimchi() {
		System.out.println("��ġ� 8,000��");
	}
	
	@Override
	public void bude() {
	System.out.println("�δ�� 8õ��");
	}
	
	@Override
	public void sunde() {
	System.out.println("���뱹 ���Ⱦ�");
	
	}

	@Override
	public void bibim() {
	System.out.println("����� 9,000��");
		
	}

	@Override
	public void gonggi() {
	System.out.println("����� 1,000��");
		
	}
}
