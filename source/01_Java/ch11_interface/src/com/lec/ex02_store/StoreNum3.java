package com.lec.ex02_store;
// ���ǰ� ���� 3ȣ�� ��ġ� 9õ��, �δ�� ����, ����� ����, ��ū���뱹 9õ��
public class StoreNum3 implements HeadQuarterStore {

	public String storeName;
	public StoreNum3(String storename) {
		this.storeName = storename;	
	}
	@Override
	public void kimchi() {
	System.out.println("��ġ� 9õ��");
	}
	@Override
	public void bude() {
	System.out.println("�δ�� ����");
	}
	@Override
	public void bibim() {
	System.out.println("����� ����");
	}
	@Override
	public void sunde() {
	System.out.println("��ū���뱹 9õ��");
	}
	public void ulkeun() {
		System.out.println("��ū���뱹 9õ��");
	}
	@Override
	public void gonggi() {
		System.out.println("����� 1,000��");
		
	}
	@Override
	public String getStorename() {
		// TODO Auto-generated method stub
		return storeName;
	}
}
