package com.lec.ex09_store;
// ���а� ���� 2ȣ��, �δ�� 8õ��, ����� 8õ��, ����� ����
public class StoreNum2 extends HeadQuarterStore {
	public StoreNum2(String storename) {
		super(storename);
		// 
	}
	@Override
	public void bude() {
	System.out.println("�δ�� 8õ��");
	}
	
	@Override
	public void bibim() {
	System.out.println("����� 8õ��");
	}
	
	@Override
	public void gonggi() {
	System.out.println("����� ����");
	}
	
}
