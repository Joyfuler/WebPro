package com.lec.ex09_store;

//���� ��ħ : ��ġ� 8õ��, �δ�� 9õ��, ����� 9õ��, ���뱹 8õ��, ����� 1000��
// HeadQuarterStore hs = new HeadQuarterStore("==����==")

public class HeadQuarterStore {
	private String storename;

		

	public HeadQuarterStore(String storename) {
		this.storename = storename;
	}
	public void kimchi() {
		System.out.println("��ġ� 8,000��");
	}
	
	public void bude () {
		System.out.println("�δ�� 9,000��");		
	}
	public void bibim () {
		System.out.println("����� 9,000��");
	}
	public void sunde () {
		System.out.println("���뱹 8,000��");
	}
	public void gonggi() {
		System.out.println("����� 1,000��");
	}
	public String getStorename() {
		return storename;
	}
}
