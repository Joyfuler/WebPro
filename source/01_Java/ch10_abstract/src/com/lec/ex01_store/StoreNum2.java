package com.lec.ex01_store;
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
	@Override
	public void kimchi() {
	System.out.println("��ġ� 8,000��");
		
	}
	@Override
	public void sunde() {
	System.out.println("���뱹 8,000��");
		
	}
	
}
