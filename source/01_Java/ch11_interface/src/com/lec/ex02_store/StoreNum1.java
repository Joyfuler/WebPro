package com.lec.ex02_store;
// �δ�� 8õ��, ���뱹 ���Ⱦ�
public class StoreNum1 implements HeadQuarterStore {

	public String storeName;
	public StoreNum1(String storename) {
		this.storeName = storename; // �������� ����Ŭ���ؼ� ������ �ִ°����� �ٷ� �������ֱ�
		
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

	@Override
	public String getStorename() {
		return storeName;
	}
}
