package com.lec.ex09_store;
// �δ�� 8õ��, ���뱹 ���Ⱦ�
public class StoreNum1 extends HeadQuarterStore {

	public StoreNum1(String storename) {
		super(storename); // �������� ����Ŭ���ؼ� ������ �ִ°����� �ٷ� �������ֱ�
		
	} 
	@Override
	public void bude() {
	System.out.println("�δ�� 8õ��");
	}
	
	@Override
	public void sunde() {
	System.out.println("���뱹 ���Ⱦ�");
	
	}
}
